package com.janaldous.todolist;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BLFCommonServerLogsTest {
	private List<Map<String, String>> serverLogsMapList;
	
	@Before
	public void setUp() {
		serverLogsMapList = new ArrayList<Map<String, String>>();
		
		//directory structure
		/* notes/
		 * 		debug/
		 * 			debug.txt
		 * 		log/
		 * 			log.txt
		 * 		todo.txt
		 */
		
	}
	
	@Test
	public void whenUseBLFLogDownloadUtils() {
		File root = new File("C:\\_Jat\\notes");
		BLFLogDownloadUtils.addFiles(root, serverLogsMapList);
		
		int noOfFiles = serverLogsMapList.size();
		
		Assert.assertEquals(5, noOfFiles);
	}
	
	@Test
	public void whenUseWebCommonMethod() {
		File root = new File("C:\\_Jat\\notes");
		serverLogsMapList = null;
		serverLogsMapList = getFileListing(root);
		
		int noOfFiles = serverLogsMapList.size();
		
		Assert.assertEquals(5, noOfFiles);
	}
	
	private List<Map<String, String>> getFileListing(File root) {
		File dir = root; //new File(System.getProperty("catalina.home") + File.separator + "logs" + File.separator);
		File[] files = dir.listFiles();

		List<Map<String, String>> mapList = new ArrayList<>();

		for (File file : files) {
			if (!file.isDirectory()) {
				Map<String, String> fileMap = new HashMap<String, String>();
				fileMap.put("name", file.getName());
				fileMap.put("size", String.valueOf(file.length() / 1024));
				fileMap.put("path", file.getAbsolutePath());

				mapList.add(fileMap);
			}
			else {
				for (File newFile : file.listFiles()) {
					Map<String, String> newFileMap = new HashMap<String, String>();
					newFileMap.put("name", newFile.getName());
					newFileMap.put("size", String.valueOf(newFile.length() / 1024));
					newFileMap.put("path", newFile.getAbsolutePath());

					mapList.add(newFileMap);
				}
			}
		}
		return mapList;
	}
}
