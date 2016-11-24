import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
public final class class94 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 391769893
   )
   int field1568;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2101373343
   )
   int field1569;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1038211391
   )
   int field1570;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 235733693
   )
   int field1571;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2007187603
   )
   int field1572;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -454179899
   )
   int field1573;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -54637175
   )
   int field1574;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -748020079
   )
   int field1575;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -298793195
   )
   int field1576;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1445351601
   )
   int field1577;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1556152873
   )
   int field1578;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1118584221
   )
   int field1579;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 776052315
   )
   int field1581;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -872046733
   )
   int field1582;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 327312731
   )
   int field1583;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1742809185
   )
   int field1584;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -310611375
   )
   int field1585;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1015838983
   )
   int field1586;

   @ObfuscatedName("es")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-1277471507"
   )
   static void method1948(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < FrameMap.field1465; ++var4) {
         ItemComposition var5 = class18.getItemDefinition(var4);
         if((!var1 || var5.field2987) && var5.field2980 == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               XItemContainer.field125 = -1;
               class175.field2659 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[2 * var2.length];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class175.field2659 = var2;
      class168.field2339 = 0;
      XItemContainer.field125 = var3;
      String[] var9 = new String[XItemContainer.field125];

      for(int var8 = 0; var8 < XItemContainer.field125; ++var8) {
         var9[var8] = class18.getItemDefinition(var2[var8]).name;
      }

      class6.method82(var9, class175.field2659);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "90782493"
   )
   public static String method1949(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;
      int var5 = var1;

      int var8;
      for(int var6 = var1 + var2; var5 < var6; var3[var4++] = (char)var8) {
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
            if(2 + var5 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128 && (var0[2 + var5] & 192) == 128) {
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
}
