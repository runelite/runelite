import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("da")
@Implements("VorbisMapping")
public class VorbisMapping {
	@ObfuscatedName("f")
	@Export("submaps")
	int submaps;
	@ObfuscatedName("i")
	@Export("mappingMux")
	int mappingMux;
	@ObfuscatedName("y")
	@Export("submapFloor")
	int[] submapFloor;
	@ObfuscatedName("w")
	@Export("submapResidue")
	int[] submapResidue;

	VorbisMapping() {
		VorbisSample.readBits(16);
		this.submaps = VorbisSample.readBit() != 0 ? VorbisSample.readBits(4) + 1 : 1;
		if (VorbisSample.readBit() != 0) {
			VorbisSample.readBits(8);
		}

		VorbisSample.readBits(2);
		if (this.submaps > 1) {
			this.mappingMux = VorbisSample.readBits(4);
		}

		this.submapFloor = new int[this.submaps];
		this.submapResidue = new int[this.submaps];

		for (int var1 = 0; var1 < this.submaps; ++var1) {
			VorbisSample.readBits(8);
			this.submapFloor[var1] = VorbisSample.readBits(8);
			this.submapResidue[var1] = VorbisSample.readBits(8);
		}

	}
}
