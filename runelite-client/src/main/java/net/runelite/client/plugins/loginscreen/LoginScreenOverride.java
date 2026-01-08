/*
 * Copyright (c) 2020, Hydrox6 <ikada@protonmail.ch>
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
package net.runelite.client.plugins.loginscreen;

import lombok.Getter;

public enum LoginScreenOverride
{
	OFF,
	NORMAL("normal.jpg", "2db7f4e9f3a2fb85ee85211e7a21434697c2acde926b6916931dc58cf26d9272"),
	OLD("old.jpg", "af41c500217536391f90a1f09e6019a2d56c9028eb0b4bd7b9fa7652cf95574a"),
	CHRISTMAS("christmas.jpg", "cc78c4aec0ade28dad752b311680c80e7c0042ecfdc6782fff955d2b58fb5363"),
	CHAMBERS_OF_XERIC("cox.jpg", "7335a51a95df8c9915961541471e4dbbd233b0e968021ea5a985f26f8d62cc9c"),
	DARKMEYER("darkmeyer.jpg", "c7f455da17680532c2675b94eca5a8016c750f237744a007a1ea177efb687ce9"),
	DRAGON_SLAYER_2("ds2.jpg", "15d4921fef17b3778596c037fef01e8a2df165b3c6aa6979b408a382a947a201"),
	FOSSIL_ISLAND("fossil_island.jpg", "03c6c2fcf1abf0f5037202950dff00cf6da32603104312b36c36b43a098e6d1b"),
	HALLOWEEN("halloween.jpg", "45ac09a26d573a9d2162bf802b60ce55e635cb7e1a4d1e8f50dde425523f0577"),
	HALLOWEEN_2019("halloween_2019.jpg", "564eb71a39db2caf662553a530a815b443fcb27f63f224a24ba2f200da79c87d"),
	INFERNO("inferno.jpg", "301e77b410df99fe2cb3ec1e96346972f2d9665d3bbfa2bd8d7ccec051ae5a54"),
	KEBOS("kebos.jpg", "835f4ca7f44ddb6771a17c681c55b5b5627bf5294a60427b7127d9c6ffdf09b2"),
	MONKEY_MADNESS_2("mm2.jpg", "628d6913491c7e7e5a72f3ac77fff8a7c6beb446952b14205d25e36726fd6cb0"),
	PRIFDDINAS("prifddinas.jpg", "9ec017f8f9513c7b2f79a37c8c85866a9f5b56b396df0109169df4f83be00b5f"),
	THEATRE_OF_BLOOD("tob.jpg", "5fdcdad28ad4214bb6906d519792c972b77d17667f3daa7f6145b5de62402d73"),
	A_KINGDOM_DIVIDED("akd.jpg", "abe6a27afaa71ca62fc1ba5aaf2e7ad44aaa48d5889276e2e5b999795faeb86d"),
	NEX("nex.jpg", "657c4a9fa700bd59d1cadd2db578f4b36fee07e38e3bf5132e5f8941ed8b4236"),
	TOMBS_OF_AMASCUT("toa.jpg", "1852a5dc0a76d62ae2506d94eedca4ea0f0ae4a1108489a974ba87512225f3df"),
	VARLAMORE("varlamore.jpg", "398c396e0c35eedc728adb9f31bc1f229d47910cf3f0c6dc119734ec832dd34b"),
	VARLAMORE_2("varlamore2.jpg", "18611f89960369718bbd54ca9c673f964ded4573a6f7cc9e9317ec6c96c36072"),
	WHILE_GUTHIX_SLEEPS("wgs.jpg", "51599649f077576f2c4a786dc0793cf32c43ba1d7982832fcecb0b85668b0f4f"),
	YAMA("yama.jpg", "f4324a4effb5ad6d0e581a3ccf07d85d930df3f8fd41200ce6e4455b4750cbbc"),
	CUSTOM,
	RANDOM;

	@Getter
	private final String fileName;

	@Getter
	private final String hash;

	LoginScreenOverride()
	{
		this.fileName = null;
		this.hash = null;
	}

	LoginScreenOverride(String fileName, String hash)
	{
		this.fileName = fileName;
		this.hash = hash;
	}
}
