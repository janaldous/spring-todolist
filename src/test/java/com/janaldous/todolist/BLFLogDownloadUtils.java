package com.janaldous.todolist;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BLFLogDownloadUtils {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

	public static void addFiles(File filePath, List<Map<String, String>> serverLogMapList) {
		if (filePath.isFile()) {
			Map<String, String> fileMap = new HashMap<String, String>();
			fileMap.put("name", filePath.getName());
			fileMap.put("size", String.valueOf(filePath.length() / 1024));
			fileMap.put("path", filePath.getAbsolutePath());
			fileMap.put("time", sdf.format(filePath.lastModified()));
			serverLogMapList.add(fileMap);
		}
		else {
			File files[] = filePath.listFiles();
			for (File dirOrFile : files) {
				addFiles(dirOrFile, serverLogMapList);
			}
		}
	}
}
