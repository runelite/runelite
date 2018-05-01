import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
@Implements("Permission")
public enum Permission implements Enumerated {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field3339(0, -1, true, false, true),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field3340(1, 0, true, true, true),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field3335(2, 1, true, true, false),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field3336(3, 2, false, false, true),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field3333(4, 3, false, false, true),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field3338(5, 10, false, false, true);

   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1883177373
   )
   final int field3337;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1689579503
   )
   public final int field3334;
   @ObfuscatedName("c")
   public final boolean field3341;
   @ObfuscatedName("h")
   public final boolean field3342;

   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3337 = var3;
      this.field3334 = var4;
      this.field3341 = var6;
      this.field3342 = var7;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "19795"
   )
   public int rsOrdinal() {
      return this.field3337;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lji;IB)V",
      garbageValue = "-78"
   )
   static void method4628(IndexData var0, int var1) {
      if(class264.NetCache_reference != null) {
         class264.NetCache_reference.offset = var1 * 8 + 5;
         int var2 = class264.NetCache_reference.readInt();
         int var3 = class264.NetCache_reference.readInt();
         var0.setInformation(var2, var3);
      } else {
         Script.requestNetFile((IndexData)null, 255, 255, 0, (byte)0, true);
         class264.NetCache_indexCaches[var1] = var0;
      }
   }
}
