package br.com.suite.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class InfoSis {
	
	public final static String getCPUSerial() throws IOException {
		String os = System.getProperty("os.name");
		try {
			if (os.startsWith("Windows")) {
				return getCPUSerialWindows();
			} else if (os.startsWith("Linux")) {
				return getCPUSerialLinux();
			} else {
				throw new IOException("unknown operating system: " + os);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IOException(ex.getMessage());
		}
	}
	
	public final static String getHDSerial() throws IOException {
		String os = System.getProperty("os.name");
		try {
			if (os.startsWith("Windows")) {
				return getHDSerialWindows("C");
			} else if (os.startsWith("Linux")) {
				return getHDSerialLinux();
			} else {
				throw new IOException("unknown operating system: " + os);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IOException(ex.getMessage());
		}
	}

	/*
	 * Captura serial de HD no WINDOWS, atraves da execucao de script visual basic
	 */
	private static String getHDSerialWindows(String drive) {
		String result = "";
		try {
			File file = File.createTempFile("tmp", ".vbs");
			file.deleteOnExit();
			FileWriter fw = new java.io.FileWriter(file);
			String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
					+ "Set colDrives = objFSO.Drives\n" + "Set objDrive = colDrives.item(\"" + drive + "\")\n"
					+ "Wscript.Echo objDrive.SerialNumber";
			fw.write(vbs);
			fw.close();
			Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = input.readLine()) != null) {
				result += line;
			}
			input.close();
		} catch (Exception e) {
		}
		if (result.trim().length() < 1 || result == null) {
			result = "NO_DISK_ID";
		}
		return result.trim();
	}
	
	/*
	 * Captura serial de HD em sistemas Linux, atraves da execucao de comandos em
	 * shell.
	 */
	private static String getHDSerialLinux() {
		String result = "";
		try {
			String[] args = { "bash", "-c", "lshw -class disk | grep serial" };
			Process p = Runtime.getRuntime().exec(args);
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = input.readLine()) != null) {
				result += line;
			}
			input.close();
		} catch (Exception e) {
		}
		if (result.trim().length() < 1 || result == null) {
			result = "NO_DISK_ID";
		}
		return filtraString(result, "serial: ");
	}

	
	/*
	 * Captura serial da CPU no WINDOWS, atraves da execucao de script visual basic
	 */
	private static String getCPUSerialWindows() {
		String result = "";
		try {
			File file = File.createTempFile("tmp", ".vbs");
			file.deleteOnExit();
			FileWriter fw = new java.io.FileWriter(file);
			String vbs = "On Error Resume Next \r\n\r\n" + "strComputer = \".\"  \r\n"
					+ "Set objWMIService = GetObject(\"winmgmts:\" _ \r\n"
					+ "    & \"{impersonationLevel=impersonate}!\\\\\" & strComputer & \"\\root\\cimv2\") \r\n"
					+ "Set colItems = objWMIService.ExecQuery(\"Select * from Win32_Processor\")  \r\n "
					+ "For Each objItem in colItems\r\n " + "    Wscript.Echo objItem.ProcessorId  \r\n "
					+ "    exit for  ' do the first cpu only! \r\n" + "Next                    ";
			fw.write(vbs);
			fw.close();
			Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = input.readLine()) != null) {
				result += line;
			}
			input.close();
		} catch (Exception e) {
		}
		if (result.trim().length() < 1 || result == null) {
			result = "NO_CPU_ID";
		}
		return result.trim();
	}

	/*
	 * Captura serial de CPU em sistemas Linux, atraves da execucao de comandos em
	 * shell.
	 */
	private static String getCPUSerialLinux() {
		String result = "";
		try {
			String[] args = { "bash", "-c", "lshw -class processor | grep serial" };
			Process p = Runtime.getRuntime().exec(args);
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = input.readLine()) != null) {
				result += line;
			}
			input.close();
		} catch (Exception e) {
		}
		if (result.trim().length() < 1 || result == null) {
			result = "NO_DISK_ID";
		}
		return filtraString(result, "serial: ");
	}
	
	public static String filtraString(String nome, String delimitador) {
		return nome.split(delimitador)[1];
	}
}
