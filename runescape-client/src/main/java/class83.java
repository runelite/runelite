import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
public class class83 {
   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   static IndexData field1337;
   @ObfuscatedName("f")
   volatile byte[] field1335;
   @ObfuscatedName("h")
   volatile boolean field1336;
   @ObfuscatedName("j")
   final URL field1333;

   class83(URL var1) {
      this.field1333 = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "65"
   )
   boolean method1614() {
      return this.field1336;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-1433744248"
   )
   byte[] method1617() {
      return this.field1335;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "1726551439"
   )
   public static Object method1621(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !AbstractByteBuffer.field2416) {
            try {
               DirectByteBuffer var2 = new DirectByteBuffer();
               var2.put(var0);
               return var2;
            } catch (Throwable var3) {
               AbstractByteBuffer.field2416 = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lia;Lia;Lia;Lgx;I)Z",
      garbageValue = "1416824400"
   )
   public static boolean method1625(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, class205 var3) {
      class204.field2503 = var0;
      class204.field2499 = var1;
      class204.field2500 = var2;
      class204.field2501 = var3;
      return true;
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "56507008"
   )
   static final void method1623(int var0) {
      int[] var1 = ItemComposition.field3531.image;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = (103 - var3) * 2048 + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if((class61.tileSettings[var0][var5][var3] & 24) == 0) {
               class36.region.method2736(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class61.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
               class36.region.method2736(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      ItemComposition.field3531.method5092();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class61.tileSettings[var0][var6][var5] & 24) == 0) {
               ScriptState.method1121(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class61.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               ScriptState.method1121(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field1154 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class36.region.method2731(class35.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = class37.getObjectDefinition(var7).mapIconId;
               if(var8 >= 0) {
                  Client.field1113[Client.field1154] = Area.field3284[var8].method4308(false);
                  Client.field935[Client.field1154] = var5;
                  Client.field946[Client.field1154] = var6;
                  ++Client.field1154;
               }
            }
         }
      }

      IndexFile.field2286.setRaster();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1704400364"
   )
   static final void method1624(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class61.tileHeights[var0][var3 + var1][var4 + var2] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class61.tileHeights[var0][var1][var3 + var2] = class61.tileHeights[var0][var1 - 1][var3 + var2];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class61.tileHeights[var0][var3 + var1][var2] = class61.tileHeights[var0][var3 + var1][var2 - 1];
         }
      }

      if(var1 > 0 && class61.tileHeights[var0][var1 - 1][var2] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1 - 1][var2];
      } else if(var2 > 0 && class61.tileHeights[var0][var1][var2 - 1] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class61.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1 - 1][var2 - 1];
      }

   }
}
