import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("m")
   public static String[] field1476;
   @ObfuscatedName("c")
   int[] field1478;
   @ObfuscatedName("d")
   int[][] field1479;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1471625225
   )
   int field1482;
   @ObfuscatedName("z")
   public static String field1483;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 22235743
   )
   int field1485;

   FrameMap(int var1, byte[] var2) {
      this.field1485 = var1;
      Buffer var3 = new Buffer(var2);
      this.field1482 = var3.readUnsignedByte();
      this.field1478 = new int[this.field1482];
      this.field1479 = new int[this.field1482][];

      int var4;
      for(var4 = 0; var4 < this.field1482; ++var4) {
         this.field1478[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.field1482; ++var4) {
         this.field1479[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.field1482; ++var4) {
         for(int var5 = 0; var5 < this.field1479[var4].length; ++var5) {
            this.field1479[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1872119296"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.isDynamicRegion = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.isDynamicRegion) {
         var1 = Client.secretCipherBuffer2.method2949();
         var2 = Client.secretCipherBuffer2.method2869();
         var3 = Client.secretCipherBuffer2.readUnsignedShort();
         XGrandExchangeOffer.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               XGrandExchangeOffer.xteaKeys[var4][var5] = Client.secretCipherBuffer2.readInt();
            }
         }

         class30.mapRegions = new int[var3];
         class22.field266 = new int[var3];
         class6.field65 = new int[var3];
         Ignore.field242 = new byte[var3][];
         class145.field2019 = new byte[var3][];
         boolean var13 = false;
         if((var2 / 8 == 48 || var2 / 8 == 49) && var1 / 8 == 48) {
            var13 = true;
         }

         if(var2 / 8 == 48 && var1 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var2 - 6) / 8; var5 <= (var2 + 6) / 8; ++var5) {
            for(var6 = (var1 - 6) / 8; var6 <= (var1 + 6) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class30.mapRegions[var3] = var7;
                  class22.field266[var3] = class33.field778.method3321("m" + var5 + "_" + var6);
                  class6.field65[var3] = class33.field778.method3321("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class174.method3274(var2, var1);
      } else {
         var1 = Client.secretCipherBuffer2.method2869();
         var2 = Client.secretCipherBuffer2.readUnsignedShort();
         var3 = Client.secretCipherBuffer2.readUnsignedShort();
         Client.secretCipherBuffer2.method3085();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.secretCipherBuffer2.method3097(1);
                  if(var7 == 1) {
                     Client.field312[var4][var5][var6] = Client.secretCipherBuffer2.method3097(26);
                  } else {
                     Client.field312[var4][var5][var6] = -1;
                  }
               }
            }
         }

         Client.secretCipherBuffer2.method3082();
         XGrandExchangeOffer.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               XGrandExchangeOffer.xteaKeys[var4][var5] = Client.secretCipherBuffer2.readInt();
            }
         }

         class30.mapRegions = new int[var3];
         class22.field266 = new int[var3];
         class6.field65 = new int[var3];
         Ignore.field242 = new byte[var3][];
         class145.field2019 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field312[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = var9 / 8 + (var8 / 8 << 8);

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(class30.mapRegions[var11] == var10) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class30.mapRegions[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class22.field266[var3] = class33.field778.method3321("m" + var11 + "_" + var12);
                        class6.field65[var3] = class33.field778.method3321("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class174.method3274(var1, var2);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-1133328748"
   )
   public static int method1752(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class18.method215(var0.charAt(var3));
      }

      return var2;
   }
}
