import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
@Implements("Huffman")
public class Huffman {
   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   static ModIcon field2322;
   @ObfuscatedName("a")
   @Export("masks")
   int[] masks;
   @ObfuscatedName("j")
   @Export("bits")
   byte[] bits;
   @ObfuscatedName("n")
   @Export("keys")
   int[] keys;

   public Huffman(byte[] var1) {
      int var2 = var1.length;
      this.masks = new int[var2];
      this.bits = var1;
      int[] var3 = new int[33];
      this.keys = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.masks[var5] = var8;
            int var9;
            int var10;
            int var11;
            int var12;
            if((var8 & var7) != 0) {
               var9 = var3[var6 - 1];
            } else {
               var9 = var8 | var7;

               for(var10 = var6 - 1; var10 >= 1; --var10) {
                  var11 = var3[var10];
                  if(var8 != var11) {
                     break;
                  }

                  var12 = 1 << 32 - var10;
                  if((var11 & var12) != 0) {
                     var3[var10] = var3[var10 - 1];
                     break;
                  }

                  var3[var10] = var11 | var12;
               }
            }

            var3[var6] = var9;

            for(var10 = var6 + 1; var10 <= 32; ++var10) {
               if(var8 == var3[var10]) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if((var8 & var12) != 0) {
                  if(this.keys[var10] == 0) {
                     this.keys[var10] = var4;
                  }

                  var10 = this.keys[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.keys.length) {
                  int[] var13 = new int[this.keys.length * 2];

                  for(int var14 = 0; var14 < this.keys.length; ++var14) {
                     var13[var14] = this.keys[var14];
                  }

                  this.keys = var13;
               }

               var12 >>>= 1;
            }

            this.keys[var10] = ~var5;
            if(var10 >= var4) {
               var4 = var10 + 1;
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI[BIIB)I",
      garbageValue = "2"
   )
   @Export("decompress")
   public int decompress(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.keys[var6];
            } else {
               ++var6;
            }

            if((var9 = this.keys[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            ++var7;
         }

         return var7 + 1 - var2;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BII[BIB)I",
      garbageValue = "86"
   )
   @Export("compress")
   public int compress(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.masks[var8];
         byte var10 = this.bits[var8];
         if(var10 == 0) {
            throw new RuntimeException("");
         }

         int var11 = var7 >> 3;
         int var12 = var7 & 7;
         var6 &= -var12 >> 31;
         int var13 = (var12 + var10 - 1 >> 3) + var11;
         var12 += 24;
         var4[var11] = (byte)(var6 |= var9 >>> var12);
         if(var11 < var13) {
            ++var11;
            var12 -= 8;
            var4[var11] = (byte)(var6 = var9 >>> var12);
            if(var11 < var13) {
               ++var11;
               var12 -= 8;
               var4[var11] = (byte)(var6 = var9 >>> var12);
               if(var11 < var13) {
                  ++var11;
                  var12 -= 8;
                  var4[var11] = (byte)(var6 = var9 >>> var12);
                  if(var11 < var13) {
                     ++var11;
                     var12 -= 8;
                     var4[var11] = (byte)(var6 = var9 << -var12);
                  }
               }
            }
         }

         var7 += var10;
      }

      return (var7 + 7 >> 3) - var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;B)Ljava/lang/String;",
      garbageValue = "-10"
   )
   static String method3067(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof class152) {
         class152 var2 = (class152)var0;
         var1 = var2.field2207 + " | ";
         var0 = var2.field2211;
      } else {
         var1 = "";
      }

      StringWriter var12 = new StringWriter();
      PrintWriter var3 = new PrintWriter(var12);
      var0.printStackTrace(var3);
      var3.close();
      String var4 = var12.toString();
      BufferedReader var5 = new BufferedReader(new StringReader(var4));
      String var6 = var5.readLine();

      while(true) {
         while(true) {
            String var7 = var5.readLine();
            if(var7 == null) {
               var1 = var1 + "| " + var6;
               return var1;
            }

            int var8 = var7.indexOf(40);
            int var9 = var7.indexOf(41, var8 + 1);
            if(var8 >= 0 && var9 >= 0) {
               String var10 = var7.substring(var8 + 1, var9);
               int var11 = var10.indexOf(".java:");
               if(var11 >= 0) {
                  var10 = var10.substring(0, var11) + var10.substring(var11 + 5);
                  var1 = var1 + var10 + ' ';
                  continue;
               }

               var7 = var7.substring(0, var8);
            }

            var7 = var7.trim();
            var7 = var7.substring(var7.lastIndexOf(32) + 1);
            var7 = var7.substring(var7.lastIndexOf(9) + 1);
            var1 = var1 + var7 + ' ';
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "1"
   )
   public static boolean method3068(char var0) {
      return var0 >= 48 && var0 <= 57;
   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lig;",
      garbageValue = "-1463115621"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class155.field2237 != null) {
         var4 = new IndexFile(var0, class155.field2237, class155.field2247[var0], 1000000);
      }

      return new IndexData(var4, World.field1295, var0, var1, var2, var3);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "-114050941"
   )
   static int method3065(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class61.method1038(class83.intStack[--WorldMapType2.intStackSize]);
      } else {
         var3 = var2?class83.field1336:class1.field9;
      }

      String var4 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 89) {
         int var6 = class83.intStack[--WorldMapType2.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class83.intStack[--WorldMapType2.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 115) {
            var8[var7] = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class83.intStack[--WorldMapType2.intStackSize]);
         }
      }

      var7 = class83.intStack[--WorldMapType2.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.field2667 = var8;
      } else if(var0 == 1401) {
         var3.field2738 = var8;
      } else if(var0 == 1402) {
         var3.field2737 = var8;
      } else if(var0 == 1403) {
         var3.mouseEnterListener = var8;
      } else if(var0 == 1404) {
         var3.mouseExitListener = var8;
      } else if(var0 == 1405) {
         var3.field2742 = var8;
      } else if(var0 == 1406) {
         var3.field2745 = var8;
      } else if(var0 == 1407) {
         var3.configListenerArgs = var8;
         var3.configTriggers = var5;
      } else if(var0 == 1408) {
         var3.renderListener = var8;
      } else if(var0 == 1409) {
         var3.field2753 = var8;
      } else if(var0 == 1410) {
         var3.field2726 = var8;
      } else if(var0 == 1411) {
         var3.field2675 = var8;
      } else if(var0 == 1412) {
         var3.mouseHoverListener = var8;
      } else if(var0 == 1414) {
         var3.tableListenerArgs = var8;
         var3.tableModTriggers = var5;
      } else if(var0 == 1415) {
         var3.skillListenerArgs = var8;
         var3.skillTriggers = var5;
      } else if(var0 == 1416) {
         var3.field2744 = var8;
      } else if(var0 == 1417) {
         var3.scrollListener = var8;
      } else if(var0 == 1418) {
         var3.field2755 = var8;
      } else if(var0 == 1419) {
         var3.field2756 = var8;
      } else if(var0 == 1420) {
         var3.field2757 = var8;
      } else if(var0 == 1421) {
         var3.field2758 = var8;
      } else if(var0 == 1422) {
         var3.field2669 = var8;
      } else if(var0 == 1423) {
         var3.field2760 = var8;
      } else if(var0 == 1424) {
         var3.field2761 = var8;
      } else if(var0 == 1425) {
         var3.field2763 = var8;
      } else if(var0 == 1426) {
         var3.field2764 = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2732 = var8;
      }

      var3.field2733 = true;
      return 1;
   }
}
