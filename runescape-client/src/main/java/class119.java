import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public abstract class class119 {
   @ObfuscatedName("ai")
   static int[] field1850;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -445671171
   )
   public int field1851;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 149243127
   )
   public int field1852;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 754739921
   )
   public int field1853;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1772710851
   )
   public int field1855;

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "-480794557"
   )
   static boolean method2252(String var0, boolean var1) {
      if(null == var0) {
         return false;
      } else {
         String var2 = class118.method2244(var0, class108.field1724);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(class118.method2244(Client.friends[var3].name, class108.field1724)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(class118.method2244(class39.localPlayer.name, class108.field1724))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILRegion;[LCollisionData;B)V",
      garbageValue = "-127"
   )
   static final void method2253(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Region var8, CollisionData[] var9) {
      Buffer var10 = new Buffer(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.method2772();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.method2772();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.readUnsignedByte();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var17 == var4 && var16 >= var5 && var16 < 8 + var5 && var15 >= var6 && var15 < var6 + 8) {
               ObjectComposition var21 = ItemLayer.getObjectDefinition(var11);
               int var22 = var2 + class48.method856(var16 & 7, var15 & 7, var7, var21.field2907, var21.field2908, var20);
               int var23 = var3 + class85.method1685(var16 & 7, var15 & 7, var7, var21.field2907, var21.field2908, var20);
               if(var22 > 0 && var23 > 0 && var22 < 103 && var23 < 103) {
                  int var24 = var1;
                  if((class10.tileSettings[1][var22][var23] & 2) == 2) {
                     var24 = var1 - 1;
                  }

                  CollisionData var25 = null;
                  if(var24 >= 0) {
                     var25 = var9[var24];
                  }

                  class6.method72(var1, var22, var23, var11, var7 + var20 & 3, var19, var8, var25);
               }
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;B)Z",
      garbageValue = "96"
   )
   protected abstract boolean vmethod2255(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Lclass196;",
      garbageValue = "699221928"
   )
   public static class196 method2256(int var0) {
      class196 var1 = (class196)class196.field2868.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class196.field2866.method3211(32, var0);
         var1 = new class196();
         if(null != var2) {
            var1.method3510(new Buffer(var2));
         }

         class196.field2868.put(var1, (long)var0);
         return var1;
      }
   }
}
