import java.io.File;
import java.io.RandomAccessFile;
import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
public class class74 extends class164 {
   @ObfuscatedName("ap")
   protected static GarbageCollectorMXBean field878;
   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   static Task field877;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIILfo;I)Z",
      garbageValue = "379386019"
   )
   public boolean vmethod3095(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2294 && var3 == super.field2293;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "572516856"
   )
   public static String method1138(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;
      int var5 = var1;

      int var8;
      for(int var6 = var2 + var1; var5 < var6; var3[var4++] = (char)var8) {
         int var7 = var0[var5++] & 255;
         if(var7 < 128) {
            if(var7 == 0) {
               var8 = '�';
            } else {
               var8 = var7;
            }
         } else if(var7 < 192) {
            var8 = '�';
         } else if(var7 < 224) {
            if(var5 < var6 && (var0[var5] & 192) == 128) {
               var8 = (var7 & 31) << 6 | var0[var5++] & 63;
               if(var8 < 128) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 240) {
            if(var5 + 1 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128) {
               var8 = (var7 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 < 2048) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 248) {
            if(var5 + 2 < var6 && (var0[var5] & 192) == 128 && 128 == (var0[var5 + 1] & 192) && (var0[var5 + 2] & 192) == 128) {
               var8 = (var7 & 7) << 18 | (var0[var5++] & 63) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 >= 65536 && var8 <= 1114111) {
                  var8 = '�';
               } else {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else {
            var8 = '�';
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(Lca;III)V",
      garbageValue = "-927748406"
   )
   static final void method1137(class90 var0, int var1, int var2) {
      class83.menuAction(var0.field1392, var0.field1390, var0.field1394, var0.field1393, var0.field1397, var0.field1397, var1, var2);
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2140657478"
   )
   static void method1135(int var0) {
      class7.field233 = new class90();
      class7.field233.field1392 = Client.menuActionParams0[var0];
      class7.field233.field1390 = Client.menuActionParams1[var0];
      class7.field233.field1394 = Client.menuTypes[var0];
      class7.field233.field1393 = Client.menuIdentifiers[var0];
      class7.field233.field1397 = Client.menuOptions[var0];
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "65755883"
   )
   static boolean method1141(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILcc;ZB)I",
      garbageValue = "3"
   )
   static int method1139(int var0, Script var1, boolean var2) {
      Widget var3 = class266.method4862(class84.intStack[--class84.intStackSize]);
      if(var0 == 2500) {
         class84.intStack[++class84.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 2501) {
         class84.intStack[++class84.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 2502) {
         class84.intStack[++class84.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         class84.intStack[++class84.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         class84.intStack[++class84.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         class84.intStack[++class84.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-471905339"
   )
   static final int method1142(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }
}
