/*
 *  Copyright (c) 2019, ThatGamerBlue <thatgamerblue@gmail.com>
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package us.runelitepl.mixinprocessor.parsers;

import us.runelitepl.mixinprocessor.MethodGarbageValue;
import us.runelitepl.mixinprocessor.MixinProcessorMojo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

public class HooksParser
{
	
	public static void run(File hooksFile, File opsFile) throws IOException, ParseException
	{
		JSONParser parser = new JSONParser();
		//region hooksFile
		String jsonContent = String.join("\n", Files.readAllLines(hooksFile.toPath()));
		JSONArray array = (JSONArray) parser.parse(jsonContent);
		
		for (Object object : array)
		{
			JSONObject rootObject = (JSONObject) object;
			String c_obbedName = (String) rootObject.get("name");
			String c_deobbedName = (String) rootObject.get("class");
			MixinProcessorMojo.classNames.put(c_deobbedName, c_obbedName);
		}
		
		int failedFields = 0;
		int failedMethods = 0;
		for (Object object : array)
		{
			JSONObject rootObject = (JSONObject) object;
			
			JSONArray fieldArray = (JSONArray) rootObject.get("fields");
			for (Object fieldObj : fieldArray)
			{
				JSONObject field = (JSONObject) fieldObj;
				String f_deobbedName = (String) field.get("field");
				String f_obbedName = (String) field.get("name");
				String f_descriptor = (String) field.get("descriptor");
				String f_owner = (String) field.get("owner");
				long f_decoder = (long) field.getOrDefault("decoder", (long) 1);
				String f_deobbedOwner = null;
				if(f_deobbedName.startsWith("__"))
				{
					continue;
				}
				for (Map.Entry<String, String> entry : MixinProcessorMojo.classNames.entrySet())
				{
					if (entry.getValue().equals(f_owner))
					{
						f_deobbedOwner = entry.getKey();
						break;
					}
				}
				if (f_deobbedOwner == null)
				{
					failedFields++;
					//stderr("Failed to find deobbed owner for field %s.%s %s", f_owner, f_obbedName, f_descriptor);
					continue;
				}
				MixinProcessorMojo.fieldNames.put(String.format("%s %s %s", f_deobbedOwner, f_deobbedName, f_descriptor),
						String.format("%s %s", f_owner, f_obbedName));
				MixinProcessorMojo.fieldDecoders.put(String.format("%s %s", f_deobbedOwner, f_deobbedName),
						f_decoder);
			}
			
			JSONArray methodArray = (JSONArray) rootObject.get("methods");
			for (Object methodObj : methodArray)
			{
				JSONObject method = (JSONObject) methodObj;
				String m_deobbedName = (String) method.get("method");
				String m_owner = (String) method.get("owner");
				String m_deobbedOwner = null;
				String m_obbedName = (String) method.get("name");
				String m_descriptor = (String) method.get("descriptor");
				if(m_deobbedName.startsWith("__"))
				{
					continue;
				}
				for (Map.Entry<String, String> entry : MixinProcessorMojo.classNames.entrySet())
				{
					if (entry.getValue().equals(m_owner))
					{
						m_deobbedOwner = entry.getKey();
						break;
					}
				}
				if (m_deobbedOwner == null)
				{
					failedMethods++;
					//stderr("Failed to find deobbed owner for method %s.%s %s", m_owner, m_obbedName, m_descriptor);
					continue;
				}
				MixinProcessorMojo.methodNames.put(String.format("%s %s %s", m_deobbedOwner, m_deobbedName, m_descriptor),
						String.format("%s %s", m_owner, m_obbedName));
			}
		}
		MixinProcessorMojo.log("%d unidentified fields", failedFields);
		MixinProcessorMojo.log("%d unidentified methods", failedMethods);
		//endregion
		
		//region opsFile
		String opsContent = String.join("\n", Files.readAllLines(opsFile.toPath()));
		JSONObject opsRoot = (JSONObject) parser.parse(opsContent);
		opsRoot.forEach((key, value) ->
		{
			String k = (String) key;
			MixinProcessorMojo.methodGarbageValues.put(k, new MethodGarbageValue(Math.toIntExact((Long) value)));
		});
		//endregion
	}
	
}
