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

package us.runelitepl.mixinprocessor.generators;

import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeAnnotationNode;
import us.runelitepl.mixinprocessor.MixinProcessorMojo;
import us.runelitepl.mixinprocessor.parsers.MethodReflector;

import java.util.HashMap;

import static us.runelitepl.mixinprocessor.generators.StaticGenerator.modifiedClasses;
import static us.runelitepl.mixinprocessor.generators.StaticGenerator.staticFields;
import static us.runelitepl.mixinprocessor.generators.StaticGenerator.staticMethods;

public class StaticStageTwoGenerator implements Opcodes
{
	
	private HashMap<String, byte[]> classes;
	
	public StaticStageTwoGenerator(HashMap<String, byte[]> classes)
	{
		this.classes = classes;
	}
	
	public void run()
	{
		for (String className : modifiedClasses)
		{
			byte[] targetBytecode = classes.getOrDefault(className, null);
			if (targetBytecode == null)
			{
				//create new class
				ClassWriter cw = new ClassWriter(0);
				FieldVisitor fv;
				MethodVisitor mv;
				
				cw.visit(V1_6, ACC_PUBLIC, className, null, "java/lang/Object", null);
				
				if (staticMethods.get(className) != null)
				{
					for (MethodNode method : staticMethods.get(className))
					{
						mv = cw.visitMethod(method.access, method.name, method.desc, method.signature,
								(String[]) method.exceptions.toArray(new String[0]));
						MethodReflector reflector = new MethodReflector(mv);
						method.accept(reflector);
					}
				}
				
				if (staticFields.get(className) != null)
				{
					for (FieldNode field : staticFields.get(className))
					{
						fv = cw.visitField(field.access, field.name, field.desc, field.signature, field.value);
						int i;
						int n;
						AnnotationNode annotation;
						if (field.visibleAnnotations != null)
						{
							i = 0;
							
							for (n = field.visibleAnnotations.size(); i < n; ++i)
							{
								annotation = (AnnotationNode) field.visibleAnnotations.get(i);
								annotation.accept(fv.visitAnnotation(annotation.desc, true));
							}
						}
						
						if (field.invisibleAnnotations != null)
						{
							i = 0;
							
							for (n = field.invisibleAnnotations.size(); i < n; ++i)
							{
								annotation = (AnnotationNode) field.invisibleAnnotations.get(i);
								annotation.accept(fv.visitAnnotation(annotation.desc, false));
							}
						}
						
						TypeAnnotationNode typeAnnotation;
						if (field.visibleTypeAnnotations != null)
						{
							i = 0;
							
							for (n = field.visibleTypeAnnotations.size(); i < n; ++i)
							{
								typeAnnotation = (TypeAnnotationNode) field.visibleTypeAnnotations.get(i);
								typeAnnotation.accept(fv
										.visitTypeAnnotation(typeAnnotation.typeRef, typeAnnotation.typePath,
												typeAnnotation.desc, true));
							}
						}
						
						if (field.invisibleTypeAnnotations != null)
						{
							i = 0;
							
							for (n = field.invisibleTypeAnnotations.size(); i < n; ++i)
							{
								typeAnnotation = (TypeAnnotationNode) field.invisibleTypeAnnotations.get(i);
								typeAnnotation.accept(fv
										.visitTypeAnnotation(typeAnnotation.typeRef, typeAnnotation.typePath,
												typeAnnotation.desc, false));
							}
						}
						
						if (field.attrs != null)
						{
							i = 0;
							
							for (n = field.attrs.size(); i < n; ++i)
							{
								fv.visitAttribute((Attribute) field.attrs.get(i));
							}
						}
						
						fv.visitEnd();
					}
				}
				
				cw.visitEnd();
				
				targetBytecode = cw.toByteArray();
			}
			else
			{
				ClassReader cr = new ClassReader(targetBytecode);
				ClassWriter cw = new ClassWriter(cr, 0);
				ClassVisitor cv = new ClassVisitor(ASM6)
				{
					@Override
					public void visit(int version, int access, String name, String signature, String superName, String[] interfaces)
					{
						super.visit(version, access, name, signature, superName, interfaces);
						if (staticMethods.get(className) != null)
						{
							for (MethodNode method : staticMethods.get(className))
							{
								MethodVisitor mv = visitMethod(method.access, method.name, method.desc,
										method.signature, (String[]) method.exceptions.toArray(new String[0]));
								MethodReflector reflector = new MethodReflector(mv);
								method.accept(reflector);
							}
						}
						
						if (staticFields.get(className) != null)
						{
							for (FieldNode field : staticFields.get(className))
							{
								FieldVisitor fv = visitField(field.access, field.name, field.desc, field.signature,
										field.value);
								int i;
								int n;
								AnnotationNode annotation;
								if (field.visibleAnnotations != null)
								{
									i = 0;
									
									for (n = field.visibleAnnotations.size(); i < n; ++i)
									{
										annotation = (AnnotationNode) field.visibleAnnotations.get(i);
										annotation.accept(fv.visitAnnotation(annotation.desc, true));
									}
								}
								
								if (field.invisibleAnnotations != null)
								{
									i = 0;
									
									for (n = field.invisibleAnnotations.size(); i < n; ++i)
									{
										annotation = (AnnotationNode) field.invisibleAnnotations.get(i);
										annotation.accept(fv.visitAnnotation(annotation.desc, false));
									}
								}
								
								TypeAnnotationNode typeAnnotation;
								if (field.visibleTypeAnnotations != null)
								{
									i = 0;
									
									for (n = field.visibleTypeAnnotations.size(); i < n; ++i)
									{
										typeAnnotation = (TypeAnnotationNode) field.visibleTypeAnnotations.get(i);
										typeAnnotation.accept(fv
												.visitTypeAnnotation(typeAnnotation.typeRef, typeAnnotation.typePath,
														typeAnnotation.desc, true));
									}
								}
								
								if (field.invisibleTypeAnnotations != null)
								{
									i = 0;
									
									for (n = field.invisibleTypeAnnotations.size(); i < n; ++i)
									{
										typeAnnotation = (TypeAnnotationNode) field.invisibleTypeAnnotations.get(i);
										typeAnnotation.accept(fv
												.visitTypeAnnotation(typeAnnotation.typeRef, typeAnnotation.typePath,
														typeAnnotation.desc, false));
									}
								}
								
								if (field.attrs != null)
								{
									i = 0;
									
									for (n = field.attrs.size(); i < n; ++i)
									{
										fv.visitAttribute((Attribute) field.attrs.get(i));
									}
								}
								
								fv.visitEnd();
							}
						}
					}
				};
				cr.accept(cv, 0);
				
				targetBytecode = cw.toByteArray();
			}
			
			classes.put(className, targetBytecode);
		}
	}
	
}
