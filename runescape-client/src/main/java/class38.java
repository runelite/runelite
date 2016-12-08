import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class38 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2130631475
   )
   int field802;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 392476239
   )
   int field803;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -58070231
   )
   int field804;
   @ObfuscatedName("h")
   String field805;
   @ObfuscatedName("jf")
   static Widget[] field806;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 299899789
   )
   int field807;
   @ObfuscatedName("eh")
   static ModIcon[] field808;
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      intValue = 295809987
   )
   protected static int field809;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -2119274161
   )
   static int field812;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1864007677"
   )
   public static int method724(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1238997523"
   )
   public static void method725() {
      if(class105.keyboard != null) {
         class105 var0 = class105.keyboard;
         synchronized(class105.keyboard) {
            class105.keyboard = null;
         }
      }

   }

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;B)[Ljava/lang/String;",
      garbageValue = "63"
   )
   static final String[] method726(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1069873541"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.field348 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.field348) {
         var1 = Client.field332.readUnsignedShort();
         var2 = Client.field332.readUnsignedShort();
         var3 = Client.field332.readUnsignedShort();
         class11.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class11.xteaKeys[var4][var5] = Client.field332.method2731();
            }
         }

         class16.mapRegions = new int[var3];
         Ignore.field206 = new int[var3];
         class37.field797 = new int[var3];
         class63.field1089 = new byte[var3][];
         World.field692 = new byte[var3][];
         boolean var13 = false;
         if((var2 / 8 == 48 || var2 / 8 == 49) && var1 / 8 == 48) {
            var13 = true;
         }

         if(var2 / 8 == 48 && var1 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var2 - 6) / 8; var5 <= (6 + var2) / 8; ++var5) {
            for(var6 = (var1 - 6) / 8; var6 <= (6 + var1) / 8; ++var6) {
               var7 = (var5 << 8) + var6;
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class16.mapRegions[var3] = var7;
                  Ignore.field206[var3] = ChatLineBuffer.field970.method3218("m" + var5 + "_" + var6);
                  class37.field797[var3] = ChatLineBuffer.field970.method3218("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class0.method2(var2, var1);
      } else {
         var1 = Client.field332.readUnsignedShort();
         var2 = Client.field332.readUnsignedShort();
         var3 = Client.field332.readUnsignedShort();
         Client.field332.method2969();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field332.method2986(1);
                  if(var7 == 1) {
                     Client.field447[var4][var5][var6] = Client.field332.method2986(26);
                  } else {
                     Client.field447[var4][var5][var6] = -1;
                  }
               }
            }
         }

         Client.field332.method2992();
         class11.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class11.xteaKeys[var4][var5] = Client.field332.method2731();
            }
         }

         class16.mapRegions = new int[var3];
         Ignore.field206 = new int[var3];
         class37.field797 = new int[var3];
         class63.field1089 = new byte[var3][];
         World.field692 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field447[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = (var8 / 8 << 8) + var9 / 8;

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(var10 == class16.mapRegions[var11]) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class16.mapRegions[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        Ignore.field206[var3] = ChatLineBuffer.field970.method3218("m" + var11 + "_" + var12);
                        class37.field797[var3] = ChatLineBuffer.field970.method3218("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class0.method2(var1, var2);
      }

   }
}
