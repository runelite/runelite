import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public class class0 extends class208 {
   @ObfuscatedName("n")
   public static class180 field0;
   @ObfuscatedName("g")
   boolean field1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -663802639
   )
   int field2;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 210911283
   )
   int field3;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1441923979
   )
   int field4;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1987261651
   )
   int field5;
   @ObfuscatedName("r")
   class173 field6;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 784896667
   )
   int field7;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1114099927
   )
   int field8;
   @ObfuscatedName("u")
   String field9;
   @ObfuscatedName("j")
   class173 field10;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = -455590221
   )
   static int field11;
   @ObfuscatedName("b")
   Object[] field12;

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "71"
   )
   @Export("xteaChanged")
   static final void method0(boolean var0) {
      client.field568 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!client.field568) {
         var1 = client.field332.method2548();
         var2 = client.field332.method2548();
         var3 = client.field332.method2516();
         class217.field3163 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class217.field3163[var4][var5] = client.field332.method2519();
            }
         }

         class141.field2153 = new int[var3];
         class59.field1184 = new int[var3];
         class98.field1643 = new int[var3];
         class13.field199 = new byte[var3][];
         class183.field2954 = new byte[var3][];
         boolean var13 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && var2 / 8 == 48) {
            var13 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (var1 + 6) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (6 + var2) / 8; ++var6) {
               var7 = (var5 << 8) + var6;
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class141.field2153[var3] = var7;
                  class59.field1184[var3] = class35.field771.method3281("m" + var5 + "_" + var6);
                  class98.field1643[var3] = class35.field771.method3281("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class49.method1006(var1, var2);
      } else {
         var1 = client.field332.method2661();
         var2 = client.field332.method2661();
         var3 = client.field332.method2516();
         client.field332.method2792();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field332.method2784(1);
                  if(var7 == 1) {
                     client.field351[var4][var5][var6] = client.field332.method2784(26);
                  } else {
                     client.field351[var4][var5][var6] = -1;
                  }
               }
            }
         }

         client.field332.method2785();
         class217.field3163 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class217.field3163[var4][var5] = client.field332.method2519();
            }
         }

         class141.field2153 = new int[var3];
         class59.field1184 = new int[var3];
         class98.field1643 = new int[var3];
         class13.field199 = new byte[var3][];
         class183.field2954 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field351[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = var9 / 8 + (var8 / 8 << 8);

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(var10 == class141.field2153[var11]) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class141.field2153[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class59.field1184[var3] = class35.field771.method3281("m" + var11 + "_" + var12);
                        class98.field1643[var3] = class35.field771.method3281("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class49.method1006(var2, var1);
      }

   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "-1524592978"
   )
   static final String[] method1(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1178043181"
   )
   public static void method2() {
      class137 var0 = class137.field2081;
      synchronized(class137.field2081) {
         ++class137.field2094;
         class137.field2082 = class137.field2105;
         class137.field2102 = 0;
         int var1;
         if(class137.field2098 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               class137.field2095[var1] = false;
            }

            class137.field2098 = class137.field2103;
         } else {
            while(class137.field2103 != class137.field2098) {
               var1 = class137.field2096[class137.field2103];
               class137.field2103 = class137.field2103 + 1 & 127;
               if(var1 < 0) {
                  class137.field2095[~var1] = false;
               } else {
                  if(!class137.field2095[var1] && class137.field2102 < class137.field2101.length - 1) {
                     class137.field2101[++class137.field2102 - 1] = var1;
                  }

                  class137.field2095[var1] = true;
               }
            }
         }

         class137.field2105 = class137.field2108;
      }
   }
}
