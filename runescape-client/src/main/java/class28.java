import java.util.LinkedList;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public abstract class class28 {
   @ObfuscatedName("c")
   short[][][] field409;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 113597095
   )
   int field410;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -597346199
   )
   int field411;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2003289417
   )
   int field412;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1135531699
   )
   int field413;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1241302647
   )
   int field414;
   @ObfuscatedName("z")
   short[][][] field416;
   @ObfuscatedName("h")
   byte[][][] field417;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1033819815
   )
   int field418;
   @ObfuscatedName("e")
   class31[][][][] field419;
   @ObfuscatedName("g")
   byte[][][] field420;
   @ObfuscatedName("fb")
   static int[] field421;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1657330943"
   )
   static int method236(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class177.method3390(class83.intStack[--class165.intStackSize]);
      } else {
         var3 = var2?class278.field3737:class37.field515;
      }

      String var4 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 89) {
         int var8 = class83.intStack[--class165.intStackSize];
         if(var8 > 0) {
            for(var5 = new int[var8]; var8-- > 0; var5[var8] = class83.intStack[--class165.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var6 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var6.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 115) {
            var6[var7] = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
         } else {
            var6[var7] = new Integer(class83.intStack[--class165.intStackSize]);
         }
      }

      var7 = class83.intStack[--class165.intStackSize];
      if(var7 != -1) {
         var6[0] = new Integer(var7);
      } else {
         var6 = null;
      }

      if(var0 == 1400) {
         var3.field2734 = var6;
      } else if(var0 == 1401) {
         var3.field2737 = var6;
      } else if(var0 == 1402) {
         var3.field2707 = var6;
      } else if(var0 == 1403) {
         var3.field2738 = var6;
      } else if(var0 == 1404) {
         var3.field2755 = var6;
      } else if(var0 == 1405) {
         var3.field2785 = var6;
      } else if(var0 == 1406) {
         var3.field2744 = var6;
      } else if(var0 == 1407) {
         var3.field2682 = var6;
         var3.field2731 = var5;
      } else if(var0 == 1408) {
         var3.field2751 = var6;
      } else if(var0 == 1409) {
         var3.field2752 = var6;
      } else if(var0 == 1410) {
         var3.field2742 = var6;
      } else if(var0 == 1411) {
         var3.field2735 = var6;
      } else if(var0 == 1412) {
         var3.field2739 = var6;
      } else if(var0 == 1414) {
         var3.field2747 = var6;
         var3.field2748 = var5;
      } else if(var0 == 1415) {
         var3.field2740 = var6;
         var3.field2750 = var5;
      } else if(var0 == 1416) {
         var3.field2743 = var6;
      } else if(var0 == 1417) {
         var3.field2753 = var6;
      } else if(var0 == 1418) {
         var3.field2754 = var6;
      } else if(var0 == 1419) {
         var3.field2649 = var6;
      } else if(var0 == 1420) {
         var3.field2756 = var6;
      } else if(var0 == 1421) {
         var3.field2757 = var6;
      } else if(var0 == 1422) {
         var3.field2758 = var6;
      } else if(var0 == 1423) {
         var3.field2759 = var6;
      } else if(var0 == 1424) {
         var3.field2760 = var6;
      } else if(var0 == 1425) {
         var3.field2762 = var6;
      } else if(var0 == 1426) {
         var3.field2763 = var6;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2761 = var6;
      }

      var3.field2732 = true;
      return 1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IILBuffer;I)V",
      garbageValue = "708983349"
   )
   void method237(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method240(var1, var2, var3, var4);
         } else {
            this.method253(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   int method238() {
      return this.field418;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IILBuffer;IB)V",
      garbageValue = "0"
   )
   void method240(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field416[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field409[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-883388968"
   )
   int method241() {
      return this.field412;
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1037178603"
   )
   static final boolean method244(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "0"
   )
   public static final void method251(int var0, int var1, int var2, int var3, int var4) {
      class7.field236.method3574(new class8(var0, var1, var2, var3, var4));
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1569253033"
   )
   int method252(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field409[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IILBuffer;II)V",
      garbageValue = "-1065131032"
   )
   void method253(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field409[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedByte();
            if(var10 != 0) {
               this.field416[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field417[var9][var1][var2] = (byte)(var11 >> 2);
               this.field420[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               class31[] var14 = this.field419[var8][var1][var2] = new class31[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3338();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new class31(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }
}
