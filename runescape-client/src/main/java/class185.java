import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class185 {
   @ObfuscatedName("r")
   @Export("jagexClDat")
   static File jagexClDat;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ldc;"
   )
   static class110 field2500;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljk;Ljava/lang/String;Ljava/lang/String;IZB)V",
      garbageValue = "48"
   )
   public static void method3498(IndexDataBase var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.getFile(var1);
      int var6 = var0.getChild(var5, var2);
      MouseRecorder.method1095(var0, var5, var6, var3, var4);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BIILec;[Lfb;I)V",
      garbageValue = "-79439646"
   )
   static final void method3499(byte[] var0, int var1, int var2, Region var3, CollisionData[] var4) {
      Buffer var5 = new Buffer(var0);
      int var6 = -1;

      while(true) {
         int var7 = var5.getUSmart();
         if(var7 == 0) {
            return;
         }

         var6 += var7;
         int var8 = 0;

         while(true) {
            int var9 = var5.getUSmart();
            if(var9 == 0) {
               break;
            }

            var8 += var9 - 1;
            int var10 = var8 & 63;
            int var11 = var8 >> 6 & 63;
            int var12 = var8 >> 12;
            int var13 = var5.readUnsignedByte();
            int var14 = var13 >> 2;
            int var15 = var13 & 3;
            int var16 = var11 + var1;
            int var17 = var10 + var2;
            if(var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
               int var18 = var12;
               if((class62.tileSettings[1][var16][var17] & 2) == 2) {
                  var18 = var12 - 1;
               }

               CollisionData var19 = null;
               if(var18 >= 0) {
                  var19 = var4[var18];
               }

               ScriptVarType.addObject(var12, var16, var17, var6, var15, var14, var3, var19);
            }
         }
      }
   }
}
