import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
public class class244 extends CacheableNode {
   @ObfuscatedName("ni")
   @ObfuscatedSignature(
      signature = "Ljv;"
   )
   static class277 field3317;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field3316;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   static NodeCache field3315;
   @ObfuscatedName("q")
   public boolean field3319;

   static {
      field3315 = new NodeCache(64);
   }

   class244() {
      this.field3319 = false;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfz;I)V",
      garbageValue = "2063801315"
   )
   void method4390(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4391(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfz;IB)V",
      garbageValue = "-72"
   )
   void method4391(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3319 = true;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IS)Liz;",
      garbageValue = "-26323"
   )
   @Export("getSpotAnimType")
   public static Spotanim getSpotAnimType(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.spotanims.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class2.field21.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Spotanim.spotanims.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Leh;IIIB)Z",
      garbageValue = "5"
   )
   public static final boolean method4400(Model var0, int var1, int var2, int var3) {
      if(!CombatInfoListHolder.method1681()) {
         return false;
      } else {
         int var4;
         int var5;
         int var6;
         int var7;
         int var10;
         int var11;
         int var12;
         int var15;
         int var16;
         if(!class132.field1983) {
            var4 = Region.pitchSin;
            var5 = Region.pitchCos;
            var6 = Region.yawSin;
            var7 = Region.yawCos;
            byte var8 = 50;
            short var9 = 3500;
            var10 = (class132.field1993 - Graphics3D.centerX) * var8 / Graphics3D.field2009;
            var11 = (class132.field1986 - Graphics3D.centerY) * var8 / Graphics3D.field2009;
            var12 = (class132.field1993 - Graphics3D.centerX) * var9 / Graphics3D.field2009;
            int var13 = (class132.field1986 - Graphics3D.centerY) * var9 / Graphics3D.field2009;
            int var14 = Graphics3D.method2663(var11, var8, var5, var4);
            var15 = Graphics3D.method2664(var11, var8, var5, var4);
            var11 = var14;
            var14 = Graphics3D.method2663(var13, var9, var5, var4);
            var16 = Graphics3D.method2664(var13, var9, var5, var4);
            var13 = var14;
            var14 = Graphics3D.method2661(var10, var15, var7, var6);
            var15 = Graphics3D.method2699(var10, var15, var7, var6);
            var10 = var14;
            var14 = Graphics3D.method2661(var12, var16, var7, var6);
            var16 = Graphics3D.method2699(var12, var16, var7, var6);
            class169.field2339 = (var10 + var14) / 2;
            class132.field1984 = (var11 + var13) / 2;
            class132.field1987 = (var15 + var16) / 2;
            class132.field1985 = (var14 - var10) / 2;
            ItemContainer.field799 = (var13 - var11) / 2;
            class132.field1980 = (var16 - var15) / 2;
            class61.field783 = Math.abs(class132.field1985);
            class277.field3748 = Math.abs(ItemContainer.field799);
            class85.field1371 = Math.abs(class132.field1980);
         }

         var4 = var0.field1967 + var1;
         var5 = var2 + var0.field1943;
         var6 = var3 + var0.field1944;
         var7 = var0.field1964;
         var15 = var0.field1946;
         var16 = var0.field1947;
         var10 = class169.field2339 - var4;
         var11 = class132.field1984 - var5;
         var12 = class132.field1987 - var6;
         return Math.abs(var10) > var7 + class61.field783?false:(Math.abs(var11) > var15 + class277.field3748?false:(Math.abs(var12) > var16 + class85.field1371?false:(Math.abs(var12 * ItemContainer.field799 - var11 * class132.field1980) > var16 * class277.field3748 + var15 * class85.field1371?false:(Math.abs(var10 * class132.field1980 - var12 * class132.field1985) > var16 * class61.field783 + var7 * class85.field1371?false:Math.abs(var11 * class132.field1985 - var10 * ItemContainer.field799) <= var7 * class277.field3748 + var15 * class61.field783))));
      }
   }
}
