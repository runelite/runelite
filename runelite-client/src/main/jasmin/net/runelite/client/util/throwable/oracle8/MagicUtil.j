; Copyright (c) 2018 Abex
; All rights reserved.
;
; Redistribution and use in source and binary forms, with or without
; modification, are permitted provided that the following conditions are met:
;
; 1. Redistributions of source code must retain the above copyright notice, this
;    list of conditions and the following disclaimer.
; 2. Redistributions in binary form must reproduce the above copyright notice,
;    this list of conditions and the following disclaimer in the documentation
;    and/or other materials provided with the distribution.
;
; THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
; ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
; WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
; DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
; ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
; (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
; ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
; (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
; SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

.class net/runelite/client/util/throwable/oracle8/MagicUtil
.super sun/reflect/MagicAccessorImpl

.method private <init>()V
	aload_0
	invokespecial sun/reflect/MagicAccessorImpl/<init>()V
	return
.end method

; You can't access Throwable.backtrace with reflection
.method static getBacktrace(Ljava/lang/Throwable;)Ljava/lang/Object;
	.limit stack 2
	.limit locals 1
	aload_0
	getfield java/lang/Throwable/backtrace Ljava/lang/Object;
	areturn
.end method

.method static getWritableStackTrace(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;
	.limit stack 2
	.limit locals 1
	aload_0
	invokespecial java/lang/Throwable/getOurStackTrace()[Ljava/lang/StackTraceElement;
	areturn
.end method

; This is a package private class, and I want my own constructor
; It always returns a (package private) java.lang.invoke.MemberName
;
; Java psudocode:
; static Object makeMethodName(Class<?> clazz, int idnum){
; 	Method method = new Method(clazz,null,null,null,null,0,idnum,null,null,null,null);
; 	MethodName methodName = new MethodName();
; 	MethodHandleNatives.init(methodName,method);
; 	return methodName;
; }
.method static makeMethodName(Ljava/lang/Class;I)Ljava/lang/Object;
	.limit stack 15
	.limit locals 2
	new java/lang/invoke/MemberName
	dup
	invokespecial java/lang/invoke/MemberName/<init>()V
	dup
	new java/lang/reflect/Method
	dup
	aload_0
	aconst_null
	aconst_null
	aconst_null
	aconst_null
	iconst_0
	iload_1
	aconst_null
	aconst_null
	aconst_null
	aconst_null
	invokespecial java/lang/reflect/Method/<init>(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;IILjava/lang/String;[B[B[B)V
	invokestatic  java/lang/invoke/MethodHandleNatives/init(Ljava/lang/invoke/MemberName;Ljava/lang/Object;)V
	areturn
.end method

; Call these package-private methods
.method static MNgetMethodType(Ljava/lang/Object;)Ljava/lang/invoke/MethodType;
	.limit stack 2
	.limit locals 1
	aload_0
	checkcast java/lang/invoke/MemberName
	invokevirtual java/lang/invoke/MemberName/getMethodType()Ljava/lang/invoke/MethodType;
	areturn
.end method

.method static MNgetClass(Ljava/lang/Object;)Ljava/lang/Class;
	.limit stack 2
	.limit locals 1
	aload_0
	checkcast java/lang/invoke/MemberName
	invokevirtual java/lang/invoke/MemberName/getDeclaringClass()Ljava/lang/Class;
	areturn
.end method

.method static MNgetName(Ljava/lang/Object;)Ljava/lang/String;
	.limit stack 2
	.limit locals 1
	aload_0
	checkcast java/lang/invoke/MemberName
	invokevirtual java/lang/invoke/MemberName/getName()Ljava/lang/String;
	areturn
.end method

.method static classPrivateGetDeclaredMethods(Ljava/lang/Class;Z)[Ljava/lang/reflect/Method;
	.limit stack 3
	.limit locals 2
	aload_0
	aload_1
	invokevirtual java/lang/Class/privateGetDeclaredMethods(Z)[Ljava/lang/reflect/Method;
	areturn
.end method

; For some reason the Methods returned from privateGetDeclaredMethods can't be propagated to the "Outside World"
; and they are copied by something like this
.method static classMethodCopyForWorld(Ljava/lang/reflect/Method;)Ljava/lang/reflect/Method;
	.limit stack 3
	.limit locals 2
	invokestatic java/lang/Class/getReflectionFactory()Lsun/reflect/ReflectionFactory;
	aload_0
	invokevirtual sun/reflect/ReflectionFactory/copyMethod(Ljava/lang/reflect/Method;)Ljava/lang/reflect/Method;
	areturn
.end method

.method static arrayContentsEq([Ljava/lang/Object;[Ljava/lang/Object;)Z
	.limit stack 3
	.limit locals 2
	aload_0
	aload_1
	invokestatic java/lang/Class/arrayContentsEq([Ljava/lang/Object;[Ljava/lang/Object;)Z
	ireturn
.end method