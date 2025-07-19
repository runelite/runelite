/*
 * Copyright (c) 2021, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.worldhopper.ping;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.unix.LibC;
import net.runelite.client.util.OSType;

interface RLLibC extends LibC
{
	RLLibC INSTANCE = Native.loadLibrary(NAME, RLLibC.class);

	int AF_INET = 2;
	int SOCK_DGRAM = 2;
	int SOL_SOCKET = OSType.getOSType() == OSType.MacOS ? 0xffff : 1;
	int IPPROTO_ICMP = 1;
	int SO_SNDTIMEO = OSType.getOSType() == OSType.MacOS ? 0x1005 : 21;
	int SO_RCVTIMEO = OSType.getOSType() == OSType.MacOS ? 0x1006 : 20;

	int socket(int domain, int type, int protocol);

	int sendto(int sockfd, byte[] buf, int len, int flags, byte[] dest_addr, int addrlen);

	int recvfrom(int sockfd, Pointer buf, int len, int flags, Pointer src_addr, Pointer addrlen);

	int setsockopt(int sockfd, int level, int optname, Pointer optval, int optlen);
}
