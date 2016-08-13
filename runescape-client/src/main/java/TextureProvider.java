import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("TextureProvider")
public class TextureProvider implements class95 {
   @ObfuscatedName("h")
   double field1689 = 1.0D;
   @ObfuscatedName("g")
   Deque field1690 = new Deque();
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -776827785
   )
   int field1691;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1430477295
   )
   int field1693 = 0;
   @ObfuscatedName("l")
   class86[] field1694;
   @ObfuscatedName("k")
   class170 field1695;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1800158211
   )
   int field1696 = 128;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method2258(double var1) {
      this.field1689 = var1;
      this.method2263();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "2"
   )
   public int vmethod2260(int var1) {
      return null != this.field1694[var1]?this.field1694[var1].field1522:0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1025454023"
   )
   public boolean vmethod2262(int var1) {
      return this.field1696 == 64;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1688091902"
   )
   public void method2263() {
      for(int var1 = 0; var1 < this.field1694.length; ++var1) {
         if(this.field1694[var1] != null) {
            this.field1694[var1].method1979();
         }
      }

      this.field1690 = new Deque();
      this.field1693 = this.field1691;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "101"
   )
   public void method2264(int var1) {
      for(int var2 = 0; var2 < this.field1694.length; ++var2) {
         class86 var3 = this.field1694[var2];
         if(null != var3 && var3.field1528 != 0 && var3.field1531) {
            var3.method1980(var1);
            var3.field1531 = false;
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;IDI)V",
      garbageValue = "64"
   )
   public TextureProvider(class170 var1, class170 var2, int var3, double var4, int var6) {
      this.field1695 = var2;
      this.field1691 = var3;
      this.field1693 = this.field1691;
      this.field1689 = var4;
      this.field1696 = var6;
      int[] var7 = var1.method3395(0);
      int var8 = var7.length;
      this.field1694 = new class86[var1.method3405(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.method3411(0, var7[var9]));
         this.field1694[var7[var9]] = new class86(var10);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "0"
   )
   public boolean vmethod2270(int var1) {
      return this.field1694[var1].field1523;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-1858605656"
   )
   @Export("load")
   public int[] load(int var1) {
      class86 var2 = this.field1694[var1];
      if(var2 != null) {
         if(null != var2.field1520) {
            this.field1690.method3964(var2);
            var2.field1531 = true;
            return var2.field1520;
         }

         boolean var3 = var2.method1978(this.field1689, this.field1696, this.field1695);
         if(var3) {
            if(this.field1693 == 0) {
               class86 var4 = (class86)this.field1690.method3967();
               var4.method1979();
            } else {
               --this.field1693;
            }

            this.field1690.method3964(var2);
            var2.field1531 = true;
            return var2.field1520;
         }
      }

      return null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass0;II)V",
      garbageValue = "-1353237188"
   )
   static void method2282(class0 var0, int var1) {
      Object[] var2 = var0.field8;
      int var3 = ((Integer)var2[0]).intValue();
      class23 var4 = class11.method165(var3);
      if(var4 != null) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field607;
         int[] var9 = var4.field608;
         byte var10 = -1;
         class38.field825 = 0;

         int var11;
         try {
            class38.field820 = new int[var4.field610];
            int var12 = 0;
            FileOnDisk.field3259 = new String[var4.field606];
            int var49 = 0;

            int var14;
            String var15;
            for(var11 = 1; var11 < var2.length; ++var11) {
               if(var2[var11] instanceof Integer) {
                  var14 = ((Integer)var2[var11]).intValue();
                  if(var14 == -2147483647) {
                     var14 = var0.field5;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field4;
                  }

                  if(var14 == -2147483645) {
                     var14 = var0.field2 != null?var0.field2.id:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field14;
                  }

                  if(var14 == -2147483643) {
                     var14 = null != var0.field2?var0.field2.index:-1;
                  }

                  if(var14 == -2147483642) {
                     var14 = null != var0.field6?var0.field6.id:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = var0.field6 != null?var0.field6.index:-1;
                  }

                  if(var14 == -2147483640) {
                     var14 = var0.field3;
                  }

                  if(var14 == -2147483639) {
                     var14 = var0.field9;
                  }

                  class38.field820[var12++] = var14;
               } else if(var2[var11] instanceof String) {
                  var15 = (String)var2[var11];
                  if(var15.equals("event_opbase")) {
                     var15 = var0.field0;
                  }

                  FileOnDisk.field3259[var49++] = var15;
               }
            }

            var11 = 0;
            class38.field829 = var0.field10;

            label2958:
            while(true) {
               ++var11;
               if(var11 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var16 = var8[var7];
               String var17;
               String var18;
               String var19;
               int var20;
               int var21;
               int var22;
               int var23;
               String var24;
               int[] var25;
               int var26;
               int var27;
               byte var28;
               if(var16 < 100) {
                  if(var16 == 0) {
                     class38.field823[var5++] = var9[var7];
                     continue;
                  }

                  if(var16 == 1) {
                     var14 = var9[var7];
                     class38.field823[var5++] = class179.widgetSettings[var14];
                     continue;
                  }

                  if(var16 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class179.widgetSettings[var14] = class38.field823[var5];
                     ClassInfo.method4080(var14);
                     continue;
                  }

                  if(var16 == 3) {
                     class38.chatboxSegments[var6++] = var4.field609[var7];
                     continue;
                  }

                  if(var16 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var16 == 7) {
                     var5 -= 2;
                     if(class38.field823[var5] != class38.field823[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var16 == 8) {
                     var5 -= 2;
                     if(class38.field823[1 + var5] == class38.field823[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var16 == 9) {
                     var5 -= 2;
                     if(class38.field823[var5] < class38.field823[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var16 == 10) {
                     var5 -= 2;
                     if(class38.field823[var5] > class38.field823[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var16 == 21) {
                     if(class38.field825 == 0) {
                        return;
                     }

                     class14 var54 = class38.field828[--class38.field825];
                     var4 = var54.field219;
                     var8 = var4.field607;
                     var9 = var4.field608;
                     var7 = var54.field213;
                     class38.field820 = var54.field214;
                     FileOnDisk.field3259 = var54.field215;
                     continue;
                  }

                  if(var16 == 25) {
                     var14 = var9[var7];
                     class38.field823[var5++] = class54.method1164(var14);
                     continue;
                  }

                  if(var16 == 27) {
                     var14 = var9[var7];
                     --var5;
                     class124.method2892(var14, class38.field823[var5]);
                     continue;
                  }

                  if(var16 == 31) {
                     var5 -= 2;
                     if(class38.field823[var5] <= class38.field823[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var16 == 32) {
                     var5 -= 2;
                     if(class38.field823[var5] >= class38.field823[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var16 == 33) {
                     class38.field823[var5++] = class38.field820[var9[var7]];
                     continue;
                  }

                  int var52;
                  if(var16 == 34) {
                     var52 = var9[var7];
                     --var5;
                     class38.field820[var52] = class38.field823[var5];
                     continue;
                  }

                  if(var16 == 35) {
                     class38.chatboxSegments[var6++] = FileOnDisk.field3259[var9[var7]];
                     continue;
                  }

                  if(var16 == 36) {
                     var52 = var9[var7];
                     --var6;
                     FileOnDisk.field3259[var52] = class38.chatboxSegments[var6];
                     continue;
                  }

                  if(var16 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     String[] var93 = class38.chatboxSegments;
                     if(var14 == 0) {
                        var24 = "";
                     } else if(var14 == 1) {
                        var17 = var93[var6];
                        if(null == var17) {
                           var24 = "null";
                        } else {
                           var24 = var17.toString();
                        }
                     } else {
                        var26 = var14 + var6;
                        var22 = 0;

                        for(var23 = var6; var23 < var26; ++var23) {
                           var18 = var93[var23];
                           if(null == var18) {
                              var22 += 4;
                           } else {
                              var22 += var18.length();
                           }
                        }

                        StringBuilder var51 = new StringBuilder(var22);

                        for(var27 = var6; var27 < var26; ++var27) {
                           var19 = var93[var27];
                           if(var19 == null) {
                              var51.append("null");
                           } else {
                              var51.append(var19);
                           }
                        }

                        var24 = var51.toString();
                     }

                     class38.chatboxSegments[var6++] = var24;
                     continue;
                  }

                  if(var16 == 38) {
                     --var5;
                     continue;
                  }

                  if(var16 == 39) {
                     --var6;
                     continue;
                  }

                  if(var16 == 40) {
                     var14 = var9[var7];
                     class23 var91 = class11.method165(var14);
                     var25 = new int[var91.field610];
                     String[] var50 = new String[var91.field606];

                     for(var22 = 0; var22 < var91.field612; ++var22) {
                        var25[var22] = class38.field823[var5 - var91.field612 + var22];
                     }

                     for(var22 = 0; var22 < var91.field613; ++var22) {
                        var50[var22] = class38.chatboxSegments[var22 + (var6 - var91.field613)];
                     }

                     var5 -= var91.field612;
                     var6 -= var91.field613;
                     class14 var53 = new class14();
                     var53.field219 = var4;
                     var53.field213 = var7;
                     var53.field214 = class38.field820;
                     var53.field215 = FileOnDisk.field3259;
                     class38.field828[++class38.field825 - 1] = var53;
                     var4 = var91;
                     var8 = var91.field607;
                     var9 = var91.field608;
                     var7 = -1;
                     class38.field820 = var25;
                     FileOnDisk.field3259 = var50;
                     continue;
                  }

                  if(var16 == 42) {
                     class38.field823[var5++] = Actor.chatMessages.method220(var9[var7]);
                     continue;
                  }

                  if(var16 == 43) {
                     var52 = var9[var7];
                     --var5;
                     Actor.chatMessages.method254(var52, class38.field823[var5]);
                     continue;
                  }

                  if(var16 == 44) {
                     var14 = var9[var7] >> 16;
                     var20 = var9[var7] & '\uffff';
                     --var5;
                     var21 = class38.field823[var5];
                     if(var21 >= 0 && var21 <= 5000) {
                        class38.field821[var14] = var21;
                        var28 = -1;
                        if(var20 == 105) {
                           var28 = 0;
                        }

                        var22 = 0;

                        while(true) {
                           if(var22 >= var21) {
                              continue label2958;
                           }

                           class38.field822[var14][var22] = var28;
                           ++var22;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var16 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var20 = class38.field823[var5];
                     if(var20 >= 0 && var20 < class38.field821[var14]) {
                        class38.field823[var5++] = class38.field822[var14][var20];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var16 == 46) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var20 = class38.field823[var5];
                     if(var20 >= 0 && var20 < class38.field821[var14]) {
                        class38.field822[var14][var20] = class38.field823[1 + var5];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var16 == 47) {
                     var15 = Actor.chatMessages.method219(var9[var7]);
                     if(null == var15) {
                        var15 = "null";
                     }

                     class38.chatboxSegments[var6++] = var15;
                     continue;
                  }

                  if(var16 == 48) {
                     var52 = var9[var7];
                     --var6;
                     Actor.chatMessages.method224(var52, class38.chatboxSegments[var6]);
                     continue;
                  }
               }

               boolean var29;
               if(var9[var7] == 1) {
                  var29 = true;
               } else {
                  var29 = false;
               }

               Widget var30;
               Widget var31;
               boolean var32;
               Widget var33;
               Widget var34;
               boolean var35;
               if(var16 < 1000) {
                  if(var16 == 100) {
                     var5 -= 3;
                     var20 = class38.field823[var5];
                     var21 = class38.field823[1 + var5];
                     var26 = class38.field823[2 + var5];
                     if(var21 == 0) {
                        throw new RuntimeException();
                     }

                     var34 = class134.method2983(var20);
                     if(null == var34.children) {
                        var34.children = new Widget[var26 + 1];
                     }

                     if(var34.children.length <= var26) {
                        Widget[] var57 = new Widget[1 + var26];

                        for(var27 = 0; var27 < var34.children.length; ++var27) {
                           var57[var27] = var34.children[var27];
                        }

                        var34.children = var57;
                     }

                     if(var26 > 0 && var34.children[var26 - 1] == null) {
                        throw new RuntimeException("" + (var26 - 1));
                     }

                     Widget var58 = new Widget();
                     var58.type = var21;
                     var58.parentId = var58.id = var34.id;
                     var58.index = var26;
                     var58.field2855 = true;
                     var34.children[var26] = var58;
                     if(var29) {
                        class18.field266 = var58;
                     } else {
                        class50.field1122 = var58;
                     }

                     class79.method1777(var34);
                     continue;
                  }

                  if(var16 == 101) {
                     var30 = var29?class18.field266:class50.field1122;
                     var31 = class134.method2983(var30.id);
                     var31.children[var30.index] = null;
                     class79.method1777(var31);
                     continue;
                  }

                  if(var16 == 102) {
                     --var5;
                     var30 = class134.method2983(class38.field823[var5]);
                     var30.children = null;
                     class79.method1777(var30);
                     continue;
                  }

                  if(var16 == 200) {
                     var5 -= 2;
                     var20 = class38.field823[var5];
                     var21 = class38.field823[1 + var5];
                     var33 = class151.method3265(var20, var21);
                     if(var33 != null && var21 != -1) {
                        class38.field823[var5++] = 1;
                        if(var29) {
                           class18.field266 = var33;
                        } else {
                           class50.field1122 = var33;
                        }
                        continue;
                     }

                     class38.field823[var5++] = 0;
                     continue;
                  }

                  if(var16 == 201) {
                     --var5;
                     var30 = class134.method2983(class38.field823[var5]);
                     if(var30 != null) {
                        class38.field823[var5++] = 1;
                        if(var29) {
                           class18.field266 = var30;
                        } else {
                           class50.field1122 = var30;
                        }
                     } else {
                        class38.field823[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var36;
                  if((var16 < 1000 || var16 >= 1100) && (var16 < 2000 || var16 >= 2100)) {
                     if(var16 >= 1100 && var16 < 1200 || var16 >= 2100 && var16 < 2200) {
                        var21 = -1;
                        if(var16 >= 2000) {
                           var16 -= 1000;
                           --var5;
                           var21 = class38.field823[var5];
                           var30 = class134.method2983(var21);
                        } else {
                           var30 = var29?class18.field266:class50.field1122;
                        }

                        if(var16 == 1100) {
                           var5 -= 2;
                           var30.itemId = class38.field823[var5];
                           if(var30.itemId > var30.scrollWidth - var30.width) {
                              var30.itemId = var30.scrollWidth - var30.width;
                           }

                           if(var30.itemId < 0) {
                              var30.itemId = 0;
                           }

                           var30.scrollY = class38.field823[1 + var5];
                           if(var30.scrollY > var30.scrollHeight - var30.height) {
                              var30.scrollY = var30.scrollHeight - var30.height;
                           }

                           if(var30.scrollY < 0) {
                              var30.scrollY = 0;
                           }

                           class79.method1777(var30);
                           continue;
                        }

                        if(var16 == 1101) {
                           --var5;
                           var30.textColor = class38.field823[var5];
                           class79.method1777(var30);
                           continue;
                        }

                        if(var16 == 1102) {
                           --var5;
                           var30.field2825 = class38.field823[var5] == 1;
                           class79.method1777(var30);
                           continue;
                        }

                        if(var16 == 1103) {
                           --var5;
                           var30.opacity = class38.field823[var5];
                           class79.method1777(var30);
                           continue;
                        }

                        if(var16 == 1104) {
                           --var5;
                           var30.field2840 = class38.field823[var5];
                           class79.method1777(var30);
                           continue;
                        }

                        if(var16 == 1105) {
                           --var5;
                           var30.textureId = class38.field823[var5];
                           class79.method1777(var30);
                           continue;
                        }

                        if(var16 == 1106) {
                           --var5;
                           var30.field2844 = class38.field823[var5];
                           class79.method1777(var30);
                           continue;
                        }

                        if(var16 == 1107) {
                           --var5;
                           var30.field2845 = class38.field823[var5] == 1;
                           class79.method1777(var30);
                           continue;
                        }

                        if(var16 == 1108) {
                           var30.modelType = 1;
                           --var5;
                           var30.modelId = class38.field823[var5];
                           class79.method1777(var30);
                           continue;
                        }

                        if(var16 == 1109) {
                           var5 -= 6;
                           var30.field2856 = class38.field823[var5];
                           var30.field2857 = class38.field823[var5 + 1];
                           var30.rotationX = class38.field823[2 + var5];
                           var30.rotationZ = class38.field823[3 + var5];
                           var30.rotationY = class38.field823[4 + var5];
                           var30.field2933 = class38.field823[var5 + 5];
                           class79.method1777(var30);
                           continue;
                        }

                        if(var16 == 1110) {
                           --var5;
                           var26 = class38.field823[var5];
                           if(var26 != var30.field2854) {
                              var30.field2854 = var26;
                              var30.field2929 = 0;
                              var30.field2930 = 0;
                              class79.method1777(var30);
                           }
                           continue;
                        }

                        if(var16 == 1111) {
                           --var5;
                           var30.field2908 = class38.field823[var5] == 1;
                           class79.method1777(var30);
                           continue;
                        }

                        if(var16 == 1112) {
                           --var6;
                           var17 = class38.chatboxSegments[var6];
                           if(!var17.equals(var30.text)) {
                              var30.text = var17;
                              class79.method1777(var30);
                           }
                           continue;
                        }

                        if(var16 == 1113) {
                           --var5;
                           var30.field2866 = class38.field823[var5];
                           class79.method1777(var30);
                           continue;
                        }

                        if(var16 == 1114) {
                           var5 -= 3;
                           var30.field2814 = class38.field823[var5];
                           var30.field2883 = class38.field823[1 + var5];
                           var30.field2869 = class38.field823[2 + var5];
                           class79.method1777(var30);
                           continue;
                        }

                        if(var16 == 1115) {
                           --var5;
                           var30.field2827 = class38.field823[var5] == 1;
                           class79.method1777(var30);
                           continue;
                        }

                        if(var16 == 1116) {
                           --var5;
                           var30.borderThickness = class38.field823[var5];
                           class79.method1777(var30);
                           continue;
                        }

                        if(var16 == 1117) {
                           --var5;
                           var30.sprite2 = class38.field823[var5];
                           class79.method1777(var30);
                           continue;
                        }

                        if(var16 == 1118) {
                           --var5;
                           var30.flippedVertically = class38.field823[var5] == 1;
                           class79.method1777(var30);
                           continue;
                        }

                        if(var16 == 1119) {
                           --var5;
                           var30.flippedHorizontally = class38.field823[var5] == 1;
                           class79.method1777(var30);
                           continue;
                        }

                        if(var16 == 1120) {
                           var5 -= 2;
                           var30.scrollWidth = class38.field823[var5];
                           var30.scrollHeight = class38.field823[var5 + 1];
                           class79.method1777(var30);
                           if(var21 != -1 && var30.type == 0) {
                              class53.method1145(Widget.widgets[var21 >> 16], var30, false);
                           }
                           continue;
                        }

                        if(var16 == 1121) {
                           class33.method718(var30.id, var30.index);
                           Client.field376 = var30;
                           class79.method1777(var30);
                           continue;
                        }

                        if(var16 == 1122) {
                           --var5;
                           var30.field2843 = class38.field823[var5];
                           class79.method1777(var30);
                           continue;
                        }

                        if(var16 == 1123) {
                           --var5;
                           var30.field2924 = class38.field823[var5];
                           class79.method1777(var30);
                           continue;
                        }

                        if(var16 == 1124) {
                           --var5;
                           var30.field2839 = class38.field823[var5];
                           class79.method1777(var30);
                           continue;
                        }

                        if(var16 == 1125) {
                           --var5;
                           var26 = class38.field823[var5];
                           class85 var63 = (class85)class85.method1971(class130.method2968(), var26);
                           if(var63 != null) {
                              var30.field2837 = var63;
                              class79.method1777(var30);
                           }
                           continue;
                        }
                     } else if((var16 < 1200 || var16 >= 1300) && (var16 < 2200 || var16 >= 2300)) {
                        if(var16 >= 1300 && var16 < 1400 || var16 >= 2300 && var16 < 2400) {
                           if(var16 >= 2000) {
                              var16 -= 1000;
                              --var5;
                              var30 = class134.method2983(class38.field823[var5]);
                           } else {
                              var30 = var29?class18.field266:class50.field1122;
                           }

                           if(var16 == 1300) {
                              --var5;
                              var21 = class38.field823[var5] - 1;
                              if(var21 >= 0 && var21 <= 9) {
                                 --var6;
                                 var30.method3560(var21, class38.chatboxSegments[var6]);
                                 continue;
                              }

                              --var6;
                              continue;
                           }

                           if(var16 == 1301) {
                              var5 -= 2;
                              var21 = class38.field823[var5];
                              var26 = class38.field823[var5 + 1];
                              var30.parent = class151.method3265(var21, var26);
                              continue;
                           }

                           if(var16 == 1302) {
                              --var5;
                              var30.field2885 = class38.field823[var5] == 1;
                              continue;
                           }

                           if(var16 == 1303) {
                              --var5;
                              var30.field2939 = class38.field823[var5];
                              continue;
                           }

                           if(var16 == 1304) {
                              --var5;
                              var30.field2884 = class38.field823[var5];
                              continue;
                           }

                           if(var16 == 1305) {
                              --var6;
                              var30.name = class38.chatboxSegments[var6];
                              continue;
                           }

                           if(var16 == 1306) {
                              --var6;
                              var30.field2835 = class38.chatboxSegments[var6];
                              continue;
                           }

                           if(var16 == 1307) {
                              var30.actions = null;
                              continue;
                           }
                        } else {
                           String var56;
                           if(var16 >= 1400 && var16 < 1500 || var16 >= 2400 && var16 < 2500) {
                              if(var16 >= 2000) {
                                 var16 -= 1000;
                                 --var5;
                                 var30 = class134.method2983(class38.field823[var5]);
                              } else {
                                 var30 = var29?class18.field266:class50.field1122;
                              }

                              --var6;
                              var56 = class38.chatboxSegments[var6];
                              int[] var61 = null;
                              if(var56.length() > 0 && var56.charAt(var56.length() - 1) == 89) {
                                 --var5;
                                 var22 = class38.field823[var5];
                                 if(var22 > 0) {
                                    for(var61 = new int[var22]; var22-- > 0; var61[var22] = class38.field823[var5]) {
                                       --var5;
                                    }
                                 }

                                 var56 = var56.substring(0, var56.length() - 1);
                              }

                              Object[] var62 = new Object[var56.length() + 1];

                              for(var23 = var62.length - 1; var23 >= 1; --var23) {
                                 if(var56.charAt(var23 - 1) == 115) {
                                    --var6;
                                    var62[var23] = class38.chatboxSegments[var6];
                                 } else {
                                    --var5;
                                    var62[var23] = new Integer(class38.field823[var5]);
                                 }
                              }

                              --var5;
                              var23 = class38.field823[var5];
                              if(var23 != -1) {
                                 var62[0] = new Integer(var23);
                              } else {
                                 var62 = null;
                              }

                              if(var16 == 1400) {
                                 var30.field2889 = var62;
                              }

                              if(var16 == 1401) {
                                 var30.field2828 = var62;
                              }

                              if(var16 == 1402) {
                                 var30.field2891 = var62;
                              }

                              if(var16 == 1403) {
                                 var30.field2893 = var62;
                              }

                              if(var16 == 1404) {
                                 var30.field2895 = var62;
                              }

                              if(var16 == 1405) {
                                 var30.field2928 = var62;
                              }

                              if(var16 == 1406) {
                                 var30.field2899 = var62;
                              }

                              if(var16 == 1407) {
                                 var30.field2833 = var62;
                                 var30.field2901 = var61;
                              }

                              if(var16 == 1408) {
                                 var30.field2881 = var62;
                              }

                              if(var16 == 1409) {
                                 var30.field2907 = var62;
                              }

                              if(var16 == 1410) {
                                 var30.field2897 = var62;
                              }

                              if(var16 == 1411) {
                                 var30.field2890 = var62;
                              }

                              if(var16 == 1412) {
                                 var30.field2894 = var62;
                              }

                              if(var16 == 1414) {
                                 var30.field2906 = var62;
                                 var30.field2805 = var61;
                              }

                              if(var16 == 1415) {
                                 var30.field2904 = var62;
                                 var30.field2871 = var61;
                              }

                              if(var16 == 1416) {
                                 var30.field2898 = var62;
                              }

                              if(var16 == 1417) {
                                 var30.field2838 = var62;
                              }

                              if(var16 == 1418) {
                                 var30.field2870 = var62;
                              }

                              if(var16 == 1419) {
                                 var30.field2858 = var62;
                              }

                              if(var16 == 1420) {
                                 var30.field2911 = var62;
                              }

                              if(var16 == 1421) {
                                 var30.field2912 = var62;
                              }

                              if(var16 == 1422) {
                                 var30.field2903 = var62;
                              }

                              if(var16 == 1423) {
                                 var30.field2914 = var62;
                              }

                              if(var16 == 1424) {
                                 var30.field2824 = var62;
                              }

                              if(var16 == 1425) {
                                 var30.field2900 = var62;
                              }

                              if(var16 == 1426) {
                                 var30.field2918 = var62;
                              }

                              if(var16 == 1427) {
                                 var30.field2916 = var62;
                              }

                              var30.field2817 = true;
                              continue;
                           }

                           if(var16 < 1600) {
                              var30 = var29?class18.field266:class50.field1122;
                              if(var16 == 1500) {
                                 class38.field823[var5++] = var30.relativeX;
                                 continue;
                              }

                              if(var16 == 1501) {
                                 class38.field823[var5++] = var30.relativeY;
                                 continue;
                              }

                              if(var16 == 1502) {
                                 class38.field823[var5++] = var30.width;
                                 continue;
                              }

                              if(var16 == 1503) {
                                 class38.field823[var5++] = var30.height;
                                 continue;
                              }

                              if(var16 == 1504) {
                                 class38.field823[var5++] = var30.isHidden?1:0;
                                 continue;
                              }

                              if(var16 == 1505) {
                                 class38.field823[var5++] = var30.parentId;
                                 continue;
                              }
                           } else if(var16 < 1700) {
                              var30 = var29?class18.field266:class50.field1122;
                              if(var16 == 1600) {
                                 class38.field823[var5++] = var30.itemId;
                                 continue;
                              }

                              if(var16 == 1601) {
                                 class38.field823[var5++] = var30.scrollY;
                                 continue;
                              }

                              if(var16 == 1602) {
                                 class38.chatboxSegments[var6++] = var30.text;
                                 continue;
                              }

                              if(var16 == 1603) {
                                 class38.field823[var5++] = var30.scrollWidth;
                                 continue;
                              }

                              if(var16 == 1604) {
                                 class38.field823[var5++] = var30.scrollHeight;
                                 continue;
                              }

                              if(var16 == 1605) {
                                 class38.field823[var5++] = var30.field2933;
                                 continue;
                              }

                              if(var16 == 1606) {
                                 class38.field823[var5++] = var30.rotationX;
                                 continue;
                              }

                              if(var16 == 1607) {
                                 class38.field823[var5++] = var30.rotationY;
                                 continue;
                              }

                              if(var16 == 1608) {
                                 class38.field823[var5++] = var30.rotationZ;
                                 continue;
                              }

                              if(var16 == 1609) {
                                 class38.field823[var5++] = var30.opacity;
                                 continue;
                              }

                              if(var16 == 1610) {
                                 class38.field823[var5++] = var30.field2839;
                                 continue;
                              }

                              if(var16 == 1611) {
                                 class38.field823[var5++] = var30.textColor;
                                 continue;
                              }

                              if(var16 == 1612) {
                                 class38.field823[var5++] = var30.field2924;
                                 continue;
                              }

                              if(var16 == 1613) {
                                 class38.field823[var5++] = var30.field2837.vmethod3316();
                                 continue;
                              }
                           } else if(var16 < 1800) {
                              var30 = var29?class18.field266:class50.field1122;
                              if(var16 == 1700) {
                                 class38.field823[var5++] = var30.item;
                                 continue;
                              }

                              if(var16 == 1701) {
                                 if(var30.item != -1) {
                                    class38.field823[var5++] = var30.stackSize;
                                 } else {
                                    class38.field823[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var16 == 1702) {
                                 class38.field823[var5++] = var30.index;
                                 continue;
                              }
                           } else if(var16 < 1900) {
                              var30 = var29?class18.field266:class50.field1122;
                              if(var16 == 1800) {
                                 class38.field823[var5++] = class215.method4089(Player.method39(var30));
                                 continue;
                              }

                              if(var16 == 1801) {
                                 --var5;
                                 var21 = class38.field823[var5];
                                 --var21;
                                 if(var30.actions != null && var21 < var30.actions.length && var30.actions[var21] != null) {
                                    class38.chatboxSegments[var6++] = var30.actions[var21];
                                    continue;
                                 }

                                 class38.chatboxSegments[var6++] = "";
                                 continue;
                              }

                              if(var16 == 1802) {
                                 if(null == var30.name) {
                                    class38.chatboxSegments[var6++] = "";
                                 } else {
                                    class38.chatboxSegments[var6++] = var30.name;
                                 }
                                 continue;
                              }
                           } else if((var16 < 1900 || var16 >= 2000) && (var16 < 2900 || var16 >= 3000)) {
                              if(var16 < 2600) {
                                 --var5;
                                 var30 = class134.method2983(class38.field823[var5]);
                                 if(var16 == 2500) {
                                    class38.field823[var5++] = var30.relativeX;
                                    continue;
                                 }

                                 if(var16 == 2501) {
                                    class38.field823[var5++] = var30.relativeY;
                                    continue;
                                 }

                                 if(var16 == 2502) {
                                    class38.field823[var5++] = var30.width;
                                    continue;
                                 }

                                 if(var16 == 2503) {
                                    class38.field823[var5++] = var30.height;
                                    continue;
                                 }

                                 if(var16 == 2504) {
                                    class38.field823[var5++] = var30.isHidden?1:0;
                                    continue;
                                 }

                                 if(var16 == 2505) {
                                    class38.field823[var5++] = var30.parentId;
                                    continue;
                                 }
                              } else if(var16 < 2700) {
                                 --var5;
                                 var30 = class134.method2983(class38.field823[var5]);
                                 if(var16 == 2600) {
                                    class38.field823[var5++] = var30.itemId;
                                    continue;
                                 }

                                 if(var16 == 2601) {
                                    class38.field823[var5++] = var30.scrollY;
                                    continue;
                                 }

                                 if(var16 == 2602) {
                                    class38.chatboxSegments[var6++] = var30.text;
                                    continue;
                                 }

                                 if(var16 == 2603) {
                                    class38.field823[var5++] = var30.scrollWidth;
                                    continue;
                                 }

                                 if(var16 == 2604) {
                                    class38.field823[var5++] = var30.scrollHeight;
                                    continue;
                                 }

                                 if(var16 == 2605) {
                                    class38.field823[var5++] = var30.field2933;
                                    continue;
                                 }

                                 if(var16 == 2606) {
                                    class38.field823[var5++] = var30.rotationX;
                                    continue;
                                 }

                                 if(var16 == 2607) {
                                    class38.field823[var5++] = var30.rotationY;
                                    continue;
                                 }

                                 if(var16 == 2608) {
                                    class38.field823[var5++] = var30.rotationZ;
                                    continue;
                                 }

                                 if(var16 == 2609) {
                                    class38.field823[var5++] = var30.opacity;
                                    continue;
                                 }

                                 if(var16 == 2610) {
                                    class38.field823[var5++] = var30.field2839;
                                    continue;
                                 }

                                 if(var16 == 2611) {
                                    class38.field823[var5++] = var30.textColor;
                                    continue;
                                 }

                                 if(var16 == 2612) {
                                    class38.field823[var5++] = var30.field2924;
                                    continue;
                                 }

                                 if(var16 == 2613) {
                                    class38.field823[var5++] = var30.field2837.vmethod3316();
                                    continue;
                                 }
                              } else if(var16 < 2800) {
                                 if(var16 == 2700) {
                                    --var5;
                                    var30 = class134.method2983(class38.field823[var5]);
                                    class38.field823[var5++] = var30.item;
                                    continue;
                                 }

                                 if(var16 == 2701) {
                                    --var5;
                                    var30 = class134.method2983(class38.field823[var5]);
                                    if(var30.item != -1) {
                                       class38.field823[var5++] = var30.stackSize;
                                    } else {
                                       class38.field823[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var16 == 2702) {
                                    --var5;
                                    var20 = class38.field823[var5];
                                    WidgetNode var59 = (WidgetNode)Client.componentTable.method3936((long)var20);
                                    if(null != var59) {
                                       class38.field823[var5++] = 1;
                                    } else {
                                       class38.field823[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var16 == 2706) {
                                    class38.field823[var5++] = Client.widgetRoot;
                                    continue;
                                 }
                              } else if(var16 < 2900) {
                                 --var5;
                                 var30 = class134.method2983(class38.field823[var5]);
                                 if(var16 == 2800) {
                                    class38.field823[var5++] = class215.method4089(Player.method39(var30));
                                    continue;
                                 }

                                 if(var16 == 2801) {
                                    --var5;
                                    var21 = class38.field823[var5];
                                    --var21;
                                    if(null != var30.actions && var21 < var30.actions.length && null != var30.actions[var21]) {
                                       class38.chatboxSegments[var6++] = var30.actions[var21];
                                       continue;
                                    }

                                    class38.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var16 == 2802) {
                                    if(null == var30.name) {
                                       class38.chatboxSegments[var6++] = "";
                                    } else {
                                       class38.chatboxSegments[var6++] = var30.name;
                                    }
                                    continue;
                                 }
                              } else {
                                 int var39;
                                 int var40;
                                 int var41;
                                 int var60;
                                 if(var16 < 3200) {
                                    if(var16 == 3100) {
                                       --var6;
                                       var24 = class38.chatboxSegments[var6];
                                       SecondaryBufferProvider.sendGameMessage(0, "", var24);
                                       continue;
                                    }

                                    if(var16 == 3101) {
                                       var5 -= 2;
                                       class20.method568(WidgetNode.localPlayer, class38.field823[var5], class38.field823[1 + var5]);
                                       continue;
                                    }

                                    if(var16 == 3103) {
                                       Client.field337.method2903(197);

                                       for(WidgetNode var65 = (WidgetNode)Client.componentTable.method3939(); null != var65; var65 = (WidgetNode)Client.componentTable.method3935()) {
                                          if(var65.field60 == 0 || var65.field60 == 3) {
                                             class145.method3130(var65, true);
                                          }
                                       }

                                       if(Client.field376 != null) {
                                          class79.method1777(Client.field376);
                                          Client.field376 = null;
                                       }
                                       continue;
                                    }

                                    if(var16 == 3104) {
                                       --var6;
                                       var24 = class38.chatboxSegments[var6];
                                       var21 = 0;
                                       boolean var42 = false;
                                       boolean var43 = false;
                                       var40 = 0;
                                       var60 = var24.length();
                                       var39 = 0;

                                       while(true) {
                                          if(var39 >= var60) {
                                             var32 = var43;
                                             break;
                                          }

                                          label3213: {
                                             char var44 = var24.charAt(var39);
                                             if(var39 == 0) {
                                                if(var44 == 45) {
                                                   var42 = true;
                                                   break label3213;
                                                }

                                                if(var44 == 43) {
                                                   break label3213;
                                                }
                                             }

                                             if(var44 >= 48 && var44 <= 57) {
                                                var41 = var44 - 48;
                                             } else if(var44 >= 65 && var44 <= 90) {
                                                var41 = var44 - 55;
                                             } else {
                                                if(var44 < 97 || var44 > 122) {
                                                   var32 = false;
                                                   break;
                                                }

                                                var41 = var44 - 87;
                                             }

                                             if(var41 >= 10) {
                                                var32 = false;
                                                break;
                                             }

                                             if(var42) {
                                                var41 = -var41;
                                             }

                                             int var45 = 10 * var40 + var41;
                                             if(var40 != var45 / 10) {
                                                var32 = false;
                                                break;
                                             }

                                             var40 = var45;
                                             var43 = true;
                                          }

                                          ++var39;
                                       }

                                       if(var32) {
                                          var22 = class5.method91(var24, 10, true);
                                          var21 = var22;
                                       }

                                       Client.field337.method2903(206);
                                       Client.field337.method2728(var21);
                                       continue;
                                    }

                                    if(var16 == 3105) {
                                       --var6;
                                       var24 = class38.chatboxSegments[var6];
                                       Client.field337.method2903(107);
                                       Client.field337.method2783(var24.length() + 1);
                                       Client.field337.method2703(var24);
                                       continue;
                                    }

                                    if(var16 == 3106) {
                                       --var6;
                                       var24 = class38.chatboxSegments[var6];
                                       Client.field337.method2903(204);
                                       Client.field337.method2783(var24.length() + 1);
                                       Client.field337.method2703(var24);
                                       continue;
                                    }

                                    if(var16 == 3107) {
                                       --var5;
                                       var20 = class38.field823[var5];
                                       --var6;
                                       var56 = class38.chatboxSegments[var6];
                                       class49.method1048(var20, var56);
                                       continue;
                                    }

                                    if(var16 == 3108) {
                                       var5 -= 3;
                                       var20 = class38.field823[var5];
                                       var21 = class38.field823[var5 + 1];
                                       var26 = class38.field823[2 + var5];
                                       var34 = class134.method2983(var26);
                                       class13.method175(var34, var20, var21);
                                       continue;
                                    }

                                    if(var16 == 3109) {
                                       var5 -= 2;
                                       var20 = class38.field823[var5];
                                       var21 = class38.field823[1 + var5];
                                       var33 = var29?class18.field266:class50.field1122;
                                       class13.method175(var33, var20, var21);
                                       continue;
                                    }

                                    if(var16 == 3110) {
                                       --var5;
                                       class214.field3188 = class38.field823[var5] == 1;
                                       continue;
                                    }

                                    if(var16 == 3111) {
                                       class38.field823[var5++] = class136.field2123.field143?1:0;
                                       continue;
                                    }

                                    if(var16 == 3112) {
                                       --var5;
                                       class136.field2123.field143 = class38.field823[var5] == 1;
                                       ObjectComposition.method886();
                                       continue;
                                    }

                                    if(var16 == 3113) {
                                       --var6;
                                       var24 = class38.chatboxSegments[var6];
                                       --var5;
                                       var35 = class38.field823[var5] == 1;
                                       FrameMap.method2384(var24, var35, false);
                                       continue;
                                    }

                                    if(var16 == 3115) {
                                       --var5;
                                       var20 = class38.field823[var5];
                                       Client.field337.method2903(45);
                                       Client.field337.method2619(var20);
                                       continue;
                                    }

                                    if(var16 == 3116) {
                                       --var5;
                                       var20 = class38.field823[var5];
                                       var6 -= 2;
                                       var56 = class38.chatboxSegments[var6];
                                       var17 = class38.chatboxSegments[var6 + 1];
                                       if(var56.length() <= 500 && var17.length() <= 500) {
                                          Client.field337.method2903(152);
                                          Client.field337.method2619(1 + class54.method1165(var56) + class54.method1165(var17));
                                          Client.field337.method2703(var17);
                                          Client.field337.method2654(var20);
                                          Client.field337.method2703(var56);
                                       }
                                       continue;
                                    }
                                 } else if(var16 < 3300) {
                                    if(var16 == 3200) {
                                       var5 -= 3;
                                       var20 = class38.field823[var5];
                                       var21 = class38.field823[var5 + 1];
                                       var26 = class38.field823[var5 + 2];
                                       if(Client.field403 != 0 && var21 != 0 && Client.field536 < 50) {
                                          Client.field319[Client.field536] = var20;
                                          Client.field538[Client.field536] = var21;
                                          Client.field539[Client.field536] = var26;
                                          Client.field541[Client.field536] = null;
                                          Client.field528[Client.field536] = 0;
                                          ++Client.field536;
                                       }
                                       continue;
                                    }

                                    if(var16 == 3201) {
                                       --var5;
                                       class31.method696(class38.field823[var5]);
                                       continue;
                                    }

                                    if(var16 == 3202) {
                                       var5 -= 2;
                                       var20 = class38.field823[var5];
                                       int var10000 = class38.field823[1 + var5];
                                       if(Client.field294 != 0 && var20 != -1) {
                                          class180.method3615(class0.field12, var20, 0, Client.field294, false);
                                          Client.field533 = true;
                                       }
                                       continue;
                                    }
                                 } else if(var16 < 3400) {
                                    if(var16 == 3300) {
                                       class38.field823[var5++] = Client.gameCycle;
                                       continue;
                                    }

                                    if(var16 == 3301) {
                                       var5 -= 2;
                                       var20 = class38.field823[var5];
                                       var21 = class38.field823[var5 + 1];
                                       class38.field823[var5++] = class31.method697(var20, var21);
                                       continue;
                                    }

                                    if(var16 == 3302) {
                                       var5 -= 2;
                                       var20 = class38.field823[var5];
                                       var21 = class38.field823[1 + var5];
                                       class38.field823[var5++] = class26.method623(var20, var21);
                                       continue;
                                    }

                                    if(var16 == 3303) {
                                       var5 -= 2;
                                       var20 = class38.field823[var5];
                                       var21 = class38.field823[1 + var5];
                                       class38.field823[var5++] = class14.method177(var20, var21);
                                       continue;
                                    }

                                    if(var16 == 3304) {
                                       --var5;
                                       var20 = class38.field823[var5];
                                       class38.field823[var5++] = class154.method3286(var20).field1170;
                                       continue;
                                    }

                                    if(var16 == 3305) {
                                       --var5;
                                       var20 = class38.field823[var5];
                                       class38.field823[var5++] = Client.boostedSkillLevels[var20];
                                       continue;
                                    }

                                    if(var16 == 3306) {
                                       --var5;
                                       var20 = class38.field823[var5];
                                       class38.field823[var5++] = Client.realSkillLevels[var20];
                                       continue;
                                    }

                                    if(var16 == 3307) {
                                       --var5;
                                       var20 = class38.field823[var5];
                                       class38.field823[var5++] = Client.skillExperiences[var20];
                                       continue;
                                    }

                                    if(var16 == 3308) {
                                       var20 = VertexNormal.plane;
                                       var21 = (WidgetNode.localPlayer.x >> 7) + class0.baseX;
                                       var26 = (WidgetNode.localPlayer.y >> 7) + class21.baseY;
                                       class38.field823[var5++] = (var20 << 28) + (var21 << 14) + var26;
                                       continue;
                                    }

                                    if(var16 == 3309) {
                                       --var5;
                                       var20 = class38.field823[var5];
                                       class38.field823[var5++] = var20 >> 14 & 16383;
                                       continue;
                                    }

                                    if(var16 == 3310) {
                                       --var5;
                                       var20 = class38.field823[var5];
                                       class38.field823[var5++] = var20 >> 28;
                                       continue;
                                    }

                                    if(var16 == 3311) {
                                       --var5;
                                       var20 = class38.field823[var5];
                                       class38.field823[var5++] = var20 & 16383;
                                       continue;
                                    }

                                    if(var16 == 3312) {
                                       class38.field823[var5++] = Client.isMembers?1:0;
                                       continue;
                                    }

                                    if(var16 == 3313) {
                                       var5 -= 2;
                                       var20 = class38.field823[var5] + '耀';
                                       var21 = class38.field823[1 + var5];
                                       class38.field823[var5++] = class31.method697(var20, var21);
                                       continue;
                                    }

                                    if(var16 == 3314) {
                                       var5 -= 2;
                                       var20 = class38.field823[var5] + '耀';
                                       var21 = class38.field823[1 + var5];
                                       class38.field823[var5++] = class26.method623(var20, var21);
                                       continue;
                                    }

                                    if(var16 == 3315) {
                                       var5 -= 2;
                                       var20 = '耀' + class38.field823[var5];
                                       var21 = class38.field823[var5 + 1];
                                       class38.field823[var5++] = class14.method177(var20, var21);
                                       continue;
                                    }

                                    if(var16 == 3316) {
                                       if(Client.field460 >= 2) {
                                          class38.field823[var5++] = Client.field460;
                                       } else {
                                          class38.field823[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var16 == 3317) {
                                       class38.field823[var5++] = Client.field312;
                                       continue;
                                    }

                                    if(var16 == 3318) {
                                       class38.field823[var5++] = Client.world;
                                       continue;
                                    }

                                    if(var16 == 3321) {
                                       class38.field823[var5++] = Client.energy;
                                       continue;
                                    }

                                    if(var16 == 3322) {
                                       class38.field823[var5++] = Client.weight;
                                       continue;
                                    }

                                    if(var16 == 3323) {
                                       if(Client.field506) {
                                          class38.field823[var5++] = 1;
                                       } else {
                                          class38.field823[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var16 == 3324) {
                                       class38.field823[var5++] = Client.flags;
                                       continue;
                                    }
                                 } else if(var16 < 3500) {
                                    class52 var66;
                                    if(var16 == 3400) {
                                       var5 -= 2;
                                       var20 = class38.field823[var5];
                                       var21 = class38.field823[var5 + 1];
                                       var66 = NPCComposition.method843(var20);
                                       if(var66.field1154 != 115) {
                                          ;
                                       }

                                       for(var22 = 0; var22 < var66.field1159; ++var22) {
                                          if(var21 == var66.field1158[var22]) {
                                             class38.chatboxSegments[var6++] = var66.field1163[var22];
                                             var66 = null;
                                             break;
                                          }
                                       }

                                       if(var66 != null) {
                                          class38.chatboxSegments[var6++] = var66.field1151;
                                       }
                                       continue;
                                    }

                                    if(var16 == 3408) {
                                       var5 -= 4;
                                       var20 = class38.field823[var5];
                                       var21 = class38.field823[1 + var5];
                                       var26 = class38.field823[var5 + 2];
                                       var22 = class38.field823[var5 + 3];
                                       var66 = NPCComposition.method843(var26);
                                       if(var66.field1155 == var20 && var66.field1154 == var21) {
                                          for(var27 = 0; var27 < var66.field1159; ++var27) {
                                             if(var22 == var66.field1158[var27]) {
                                                if(var21 == 115) {
                                                   class38.chatboxSegments[var6++] = var66.field1163[var27];
                                                } else {
                                                   class38.field823[var5++] = var66.field1160[var27];
                                                }

                                                var66 = null;
                                                break;
                                             }
                                          }

                                          if(null != var66) {
                                             if(var21 == 115) {
                                                class38.chatboxSegments[var6++] = var66.field1151;
                                             } else {
                                                class38.field823[var5++] = var66.field1156;
                                             }
                                          }
                                          continue;
                                       }

                                       if(var21 == 115) {
                                          class38.chatboxSegments[var6++] = "null";
                                       } else {
                                          class38.field823[var5++] = 0;
                                       }
                                       continue;
                                    }
                                 } else {
                                    boolean var71;
                                    if(var16 < 3700) {
                                       if(var16 == 3600) {
                                          if(Client.field562 == 0) {
                                             class38.field823[var5++] = -2;
                                          } else if(Client.field562 == 1) {
                                             class38.field823[var5++] = -1;
                                          } else {
                                             class38.field823[var5++] = Client.friendCount;
                                          }
                                          continue;
                                       }

                                       if(var16 == 3601) {
                                          --var5;
                                          var20 = class38.field823[var5];
                                          if(Client.field562 == 2 && var20 < Client.friendCount) {
                                             class38.chatboxSegments[var6++] = Client.friends[var20].name;
                                             class38.chatboxSegments[var6++] = Client.friends[var20].previousName;
                                             continue;
                                          }

                                          class38.chatboxSegments[var6++] = "";
                                          class38.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       if(var16 == 3602) {
                                          --var5;
                                          var20 = class38.field823[var5];
                                          if(Client.field562 == 2 && var20 < Client.friendCount) {
                                             class38.field823[var5++] = Client.friends[var20].world;
                                             continue;
                                          }

                                          class38.field823[var5++] = 0;
                                          continue;
                                       }

                                       if(var16 == 3603) {
                                          --var5;
                                          var20 = class38.field823[var5];
                                          if(Client.field562 == 2 && var20 < Client.friendCount) {
                                             class38.field823[var5++] = Client.friends[var20].rank;
                                             continue;
                                          }

                                          class38.field823[var5++] = 0;
                                          continue;
                                       }

                                       if(var16 == 3604) {
                                          --var6;
                                          var24 = class38.chatboxSegments[var6];
                                          --var5;
                                          var21 = class38.field823[var5];
                                          class43.method890(var24, var21);
                                          continue;
                                       }

                                       if(var16 == 3605) {
                                          --var6;
                                          var24 = class38.chatboxSegments[var6];
                                          class118.method2568(var24);
                                          continue;
                                       }

                                       if(var16 == 3606) {
                                          --var6;
                                          var24 = class38.chatboxSegments[var6];
                                          if(null == var24) {
                                             continue;
                                          }

                                          var56 = class156.method3300(var24, Client.field518);
                                          if(var56 == null) {
                                             continue;
                                          }

                                          var26 = 0;

                                          while(true) {
                                             if(var26 >= Client.friendCount) {
                                                continue label2958;
                                             }

                                             Friend var75 = Client.friends[var26];
                                             String var70 = var75.name;
                                             var18 = class156.method3300(var70, Client.field518);
                                             if(null != var24 && null != var70) {
                                                if(!var24.startsWith("#") && !var70.startsWith("#")) {
                                                   var71 = var56.equals(var18);
                                                } else {
                                                   var71 = var24.equals(var70);
                                                }
                                             } else {
                                                var71 = false;
                                             }

                                             if(var71) {
                                                --Client.friendCount;

                                                for(var60 = var26; var60 < Client.friendCount; ++var60) {
                                                   Client.friends[var60] = Client.friends[1 + var60];
                                                }

                                                Client.field385 = Client.field478;
                                                Client.field337.method2903(47);
                                                Client.field337.method2783(class54.method1165(var24));
                                                Client.field337.method2703(var24);
                                                continue label2958;
                                             }

                                             ++var26;
                                          }
                                       }

                                       if(var16 == 3607) {
                                          --var6;
                                          var24 = class38.chatboxSegments[var6];
                                          class4.method46(var24, false);
                                          continue;
                                       }

                                       if(var16 == 3608) {
                                          --var6;
                                          var24 = class38.chatboxSegments[var6];
                                          class165.method3340(var24);
                                          continue;
                                       }

                                       if(var16 == 3609) {
                                          --var6;
                                          var24 = class38.chatboxSegments[var6];
                                          class155[] var74 = class128.method2954();

                                          for(var26 = 0; var26 < var74.length; ++var26) {
                                             class155 var68 = var74[var26];
                                             if(var68.field2325 != -1 && var24.startsWith(XClanMember.method615(var68.field2325))) {
                                                var24 = var24.substring(6 + Integer.toString(var68.field2325).length());
                                                break;
                                             }
                                          }

                                          class38.field823[var5++] = class145.method3128(var24, false)?1:0;
                                          continue;
                                       }

                                       char var67;
                                       String var69;
                                       String[] var72;
                                       long var73;
                                       if(var16 == 3611) {
                                          if(Client.field363 == null) {
                                             class38.chatboxSegments[var6++] = "";
                                             continue;
                                          }

                                          var72 = class38.chatboxSegments;
                                          var21 = var6++;
                                          var69 = Client.field363;
                                          var73 = 0L;
                                          var39 = var69.length();

                                          for(var41 = 0; var41 < var39; ++var41) {
                                             var73 *= 37L;
                                             var67 = var69.charAt(var41);
                                             if(var67 >= 65 && var67 <= 90) {
                                                var73 += (long)(1 + var67 - 65);
                                             } else if(var67 >= 97 && var67 <= 122) {
                                                var73 += (long)(var67 + 1 - 97);
                                             } else if(var67 >= 48 && var67 <= 57) {
                                                var73 += (long)(27 + var67 - 48);
                                             }

                                             if(var73 >= 177917621779460413L) {
                                                break;
                                             }
                                          }

                                          while(var73 % 37L == 0L && var73 != 0L) {
                                             var73 /= 37L;
                                          }

                                          var19 = class33.method701(var73);
                                          if(var19 == null) {
                                             var19 = "";
                                          }

                                          var72[var21] = var19;
                                          continue;
                                       }

                                       if(var16 == 3612) {
                                          if(Client.field363 != null) {
                                             class38.field823[var5++] = Client.field522;
                                          } else {
                                             class38.field823[var5++] = 0;
                                          }
                                          continue;
                                       }

                                       if(var16 == 3613) {
                                          --var5;
                                          var20 = class38.field823[var5];
                                          if(null != Client.field363 && var20 < Client.field522) {
                                             class38.chatboxSegments[var6++] = class4.clanMembers[var20].username;
                                             continue;
                                          }

                                          class38.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       if(var16 == 3614) {
                                          --var5;
                                          var20 = class38.field823[var5];
                                          if(null != Client.field363 && var20 < Client.field522) {
                                             class38.field823[var5++] = class4.clanMembers[var20].world;
                                             continue;
                                          }

                                          class38.field823[var5++] = 0;
                                          continue;
                                       }

                                       if(var16 == 3615) {
                                          --var5;
                                          var20 = class38.field823[var5];
                                          if(null != Client.field363 && var20 < Client.field522) {
                                             class38.field823[var5++] = class4.clanMembers[var20].rank;
                                             continue;
                                          }

                                          class38.field823[var5++] = 0;
                                          continue;
                                       }

                                       if(var16 == 3616) {
                                          class38.field823[var5++] = class178.field2952;
                                          continue;
                                       }

                                       if(var16 == 3617) {
                                          --var6;
                                          var24 = class38.chatboxSegments[var6];
                                          class26.method628(var24);
                                          continue;
                                       }

                                       if(var16 == 3618) {
                                          class38.field823[var5++] = Item.field710;
                                          continue;
                                       }

                                       if(var16 == 3619) {
                                          --var6;
                                          var24 = class38.chatboxSegments[var6];
                                          if(!var24.equals("")) {
                                             Client.field337.method2903(3);
                                             Client.field337.method2783(class54.method1165(var24));
                                             Client.field337.method2703(var24);
                                          }
                                          continue;
                                       }

                                       if(var16 == 3620) {
                                          Client.field337.method2903(3);
                                          Client.field337.method2783(0);
                                          continue;
                                       }

                                       if(var16 == 3621) {
                                          if(Client.field562 == 0) {
                                             class38.field823[var5++] = -1;
                                          } else {
                                             class38.field823[var5++] = Client.ignoreCount;
                                          }
                                          continue;
                                       }

                                       if(var16 == 3622) {
                                          --var5;
                                          var20 = class38.field823[var5];
                                          if(Client.field562 != 0 && var20 < Client.ignoreCount) {
                                             class38.chatboxSegments[var6++] = Client.ignores[var20].name;
                                             class38.chatboxSegments[var6++] = Client.ignores[var20].previousName;
                                             continue;
                                          }

                                          class38.chatboxSegments[var6++] = "";
                                          class38.chatboxSegments[var6++] = "";
                                          continue;
                                       }

                                       if(var16 == 3623) {
                                          --var6;
                                          var24 = class38.chatboxSegments[var6];
                                          if(var24.startsWith(XClanMember.method615(0)) || var24.startsWith(XClanMember.method615(1))) {
                                             var24 = var24.substring(7);
                                          }

                                          class38.field823[var5++] = class107.method2395(var24)?1:0;
                                          continue;
                                       }

                                       if(var16 == 3624) {
                                          --var5;
                                          var20 = class38.field823[var5];
                                          if(class4.clanMembers != null && var20 < Client.field522 && class4.clanMembers[var20].username.equalsIgnoreCase(WidgetNode.localPlayer.name)) {
                                             class38.field823[var5++] = 1;
                                             continue;
                                          }

                                          class38.field823[var5++] = 0;
                                          continue;
                                       }

                                       if(var16 == 3625) {
                                          if(null == Client.field521) {
                                             class38.chatboxSegments[var6++] = "";
                                             continue;
                                          }

                                          var72 = class38.chatboxSegments;
                                          var21 = var6++;
                                          var69 = Client.field521;
                                          var73 = 0L;
                                          var39 = var69.length();

                                          for(var41 = 0; var41 < var39; ++var41) {
                                             var73 *= 37L;
                                             var67 = var69.charAt(var41);
                                             if(var67 >= 65 && var67 <= 90) {
                                                var73 += (long)(var67 + 1 - 65);
                                             } else if(var67 >= 97 && var67 <= 122) {
                                                var73 += (long)(1 + var67 - 97);
                                             } else if(var67 >= 48 && var67 <= 57) {
                                                var73 += (long)(27 + var67 - 48);
                                             }

                                             if(var73 >= 177917621779460413L) {
                                                break;
                                             }
                                          }

                                          while(0L == var73 % 37L && 0L != var73) {
                                             var73 /= 37L;
                                          }

                                          var19 = class33.method701(var73);
                                          if(var19 == null) {
                                             var19 = "";
                                          }

                                          var72[var21] = var19;
                                          continue;
                                       }
                                    } else {
                                       long var77;
                                       if(var16 < 4000) {
                                          if(var16 == 3903) {
                                             --var5;
                                             var20 = class38.field823[var5];
                                             class38.field823[var5++] = Client.grandExchangeOffers[var20].method4148();
                                             continue;
                                          }

                                          if(var16 == 3904) {
                                             --var5;
                                             var20 = class38.field823[var5];
                                             class38.field823[var5++] = Client.grandExchangeOffers[var20].itemId;
                                             continue;
                                          }

                                          if(var16 == 3905) {
                                             --var5;
                                             var20 = class38.field823[var5];
                                             class38.field823[var5++] = Client.grandExchangeOffers[var20].price;
                                             continue;
                                          }

                                          if(var16 == 3906) {
                                             --var5;
                                             var20 = class38.field823[var5];
                                             class38.field823[var5++] = Client.grandExchangeOffers[var20].totalQuantity;
                                             continue;
                                          }

                                          if(var16 == 3907) {
                                             --var5;
                                             var20 = class38.field823[var5];
                                             class38.field823[var5++] = Client.grandExchangeOffers[var20].quantitySold;
                                             continue;
                                          }

                                          if(var16 == 3908) {
                                             --var5;
                                             var20 = class38.field823[var5];
                                             class38.field823[var5++] = Client.grandExchangeOffers[var20].spent;
                                             continue;
                                          }

                                          if(var16 == 3910) {
                                             --var5;
                                             var20 = class38.field823[var5];
                                             var21 = Client.grandExchangeOffers[var20].method4144();
                                             class38.field823[var5++] = var21 == 0?1:0;
                                             continue;
                                          }

                                          if(var16 == 3911) {
                                             --var5;
                                             var20 = class38.field823[var5];
                                             var21 = Client.grandExchangeOffers[var20].method4144();
                                             class38.field823[var5++] = var21 == 2?1:0;
                                             continue;
                                          }

                                          if(var16 == 3912) {
                                             --var5;
                                             var20 = class38.field823[var5];
                                             var21 = Client.grandExchangeOffers[var20].method4144();
                                             class38.field823[var5++] = var21 == 5?1:0;
                                             continue;
                                          }

                                          if(var16 == 3913) {
                                             --var5;
                                             var20 = class38.field823[var5];
                                             var21 = Client.grandExchangeOffers[var20].method4144();
                                             class38.field823[var5++] = var21 == 1?1:0;
                                             continue;
                                          }

                                          if(var16 == 3914) {
                                             --var5;
                                             var71 = class38.field823[var5] == 1;
                                             if(class162.field2659 != null) {
                                                class162.field2659.method4159(class224.field3223, var71);
                                             }
                                             continue;
                                          }

                                          if(var16 == 3915) {
                                             --var5;
                                             var71 = class38.field823[var5] == 1;
                                             if(class162.field2659 != null) {
                                                class162.field2659.method4159(class224.field3222, var71);
                                             }
                                             continue;
                                          }

                                          if(var16 == 3916) {
                                             var5 -= 2;
                                             var71 = class38.field823[var5] == 1;
                                             var35 = class38.field823[1 + var5] == 1;
                                             if(null != class162.field2659) {
                                                class162.field2659.method4159(new class22(var35), var71);
                                             }
                                             continue;
                                          }

                                          if(var16 == 3917) {
                                             --var5;
                                             var71 = class38.field823[var5] == 1;
                                             if(class162.field2659 != null) {
                                                class162.field2659.method4159(class224.field3221, var71);
                                             }
                                             continue;
                                          }

                                          if(var16 == 3918) {
                                             --var5;
                                             var71 = class38.field823[var5] == 1;
                                             if(null != class162.field2659) {
                                                class162.field2659.method4159(class224.field3224, var71);
                                             }
                                             continue;
                                          }

                                          if(var16 == 3919) {
                                             class38.field823[var5++] = null == class162.field2659?0:class162.field2659.field3220.size();
                                             continue;
                                          }

                                          class217 var87;
                                          if(var16 == 3920) {
                                             --var5;
                                             var20 = class38.field823[var5];
                                             var87 = (class217)class162.field2659.field3220.get(var20);
                                             class38.field823[var5++] = var87.field3208;
                                             continue;
                                          }

                                          if(var16 == 3921) {
                                             --var5;
                                             var20 = class38.field823[var5];
                                             var87 = (class217)class162.field2659.field3220.get(var20);
                                             class38.chatboxSegments[var6++] = var87.method4102();
                                             continue;
                                          }

                                          if(var16 == 3922) {
                                             --var5;
                                             var20 = class38.field823[var5];
                                             var87 = (class217)class162.field2659.field3220.get(var20);
                                             class38.chatboxSegments[var6++] = var87.method4101();
                                             continue;
                                          }

                                          if(var16 == 3923) {
                                             --var5;
                                             var20 = class38.field823[var5];
                                             var87 = (class217)class162.field2659.field3220.get(var20);
                                             var77 = class56.method1249() - World.field677 - var87.field3209;
                                             var23 = (int)(var77 / 3600000L);
                                             var27 = (int)((var77 - (long)(3600000 * var23)) / 60000L);
                                             var40 = (int)((var77 - (long)(var23 * 3600000) - (long)('\uea60' * var27)) / 1000L);
                                             String var46 = var23 + ":" + var27 / 10 + var27 % 10 + ":" + var40 / 10 + var40 % 10;
                                             class38.chatboxSegments[var6++] = var46;
                                             continue;
                                          }

                                          if(var16 == 3924) {
                                             --var5;
                                             var20 = class38.field823[var5];
                                             var87 = (class217)class162.field2659.field3220.get(var20);
                                             class38.field823[var5++] = var87.field3206.totalQuantity;
                                             continue;
                                          }

                                          if(var16 == 3925) {
                                             --var5;
                                             var20 = class38.field823[var5];
                                             var87 = (class217)class162.field2659.field3220.get(var20);
                                             class38.field823[var5++] = var87.field3206.price;
                                             continue;
                                          }

                                          if(var16 == 3926) {
                                             --var5;
                                             var20 = class38.field823[var5];
                                             var87 = (class217)class162.field2659.field3220.get(var20);
                                             class38.field823[var5++] = var87.field3206.itemId;
                                             continue;
                                          }
                                       } else {
                                          long var81;
                                          if(var16 < 4100) {
                                             if(var16 == 4000) {
                                                var5 -= 2;
                                                var20 = class38.field823[var5];
                                                var21 = class38.field823[1 + var5];
                                                class38.field823[var5++] = var21 + var20;
                                                continue;
                                             }

                                             if(var16 == 4001) {
                                                var5 -= 2;
                                                var20 = class38.field823[var5];
                                                var21 = class38.field823[var5 + 1];
                                                class38.field823[var5++] = var20 - var21;
                                                continue;
                                             }

                                             if(var16 == 4002) {
                                                var5 -= 2;
                                                var20 = class38.field823[var5];
                                                var21 = class38.field823[1 + var5];
                                                class38.field823[var5++] = var21 * var20;
                                                continue;
                                             }

                                             if(var16 == 4003) {
                                                var5 -= 2;
                                                var20 = class38.field823[var5];
                                                var21 = class38.field823[1 + var5];
                                                class38.field823[var5++] = var20 / var21;
                                                continue;
                                             }

                                             if(var16 == 4004) {
                                                --var5;
                                                var20 = class38.field823[var5];
                                                class38.field823[var5++] = (int)(Math.random() * (double)var20);
                                                continue;
                                             }

                                             if(var16 == 4005) {
                                                --var5;
                                                var20 = class38.field823[var5];
                                                class38.field823[var5++] = (int)(Math.random() * (double)(1 + var20));
                                                continue;
                                             }

                                             if(var16 == 4006) {
                                                var5 -= 5;
                                                var20 = class38.field823[var5];
                                                var21 = class38.field823[var5 + 1];
                                                var26 = class38.field823[var5 + 2];
                                                var22 = class38.field823[3 + var5];
                                                var23 = class38.field823[4 + var5];
                                                class38.field823[var5++] = var20 + (var23 - var26) * (var21 - var20) / (var22 - var26);
                                                continue;
                                             }

                                             if(var16 == 4007) {
                                                var5 -= 2;
                                                var20 = class38.field823[var5];
                                                var21 = class38.field823[var5 + 1];
                                                class38.field823[var5++] = var21 * var20 / 100 + var20;
                                                continue;
                                             }

                                             if(var16 == 4008) {
                                                var5 -= 2;
                                                var20 = class38.field823[var5];
                                                var21 = class38.field823[var5 + 1];
                                                class38.field823[var5++] = var20 | 1 << var21;
                                                continue;
                                             }

                                             if(var16 == 4009) {
                                                var5 -= 2;
                                                var20 = class38.field823[var5];
                                                var21 = class38.field823[1 + var5];
                                                class38.field823[var5++] = var20 & -1 - (1 << var21);
                                                continue;
                                             }

                                             if(var16 == 4010) {
                                                var5 -= 2;
                                                var20 = class38.field823[var5];
                                                var21 = class38.field823[1 + var5];
                                                class38.field823[var5++] = (var20 & 1 << var21) != 0?1:0;
                                                continue;
                                             }

                                             if(var16 == 4011) {
                                                var5 -= 2;
                                                var20 = class38.field823[var5];
                                                var21 = class38.field823[1 + var5];
                                                class38.field823[var5++] = var20 % var21;
                                                continue;
                                             }

                                             if(var16 == 4012) {
                                                var5 -= 2;
                                                var20 = class38.field823[var5];
                                                var21 = class38.field823[1 + var5];
                                                if(var20 == 0) {
                                                   class38.field823[var5++] = 0;
                                                } else {
                                                   class38.field823[var5++] = (int)Math.pow((double)var20, (double)var21);
                                                }
                                                continue;
                                             }

                                             if(var16 == 4013) {
                                                var5 -= 2;
                                                var20 = class38.field823[var5];
                                                var21 = class38.field823[var5 + 1];
                                                if(var20 == 0) {
                                                   class38.field823[var5++] = 0;
                                                } else if(var21 == 0) {
                                                   class38.field823[var5++] = Integer.MAX_VALUE;
                                                } else {
                                                   class38.field823[var5++] = (int)Math.pow((double)var20, 1.0D / (double)var21);
                                                }
                                                continue;
                                             }

                                             if(var16 == 4014) {
                                                var5 -= 2;
                                                var20 = class38.field823[var5];
                                                var21 = class38.field823[1 + var5];
                                                class38.field823[var5++] = var20 & var21;
                                                continue;
                                             }

                                             if(var16 == 4015) {
                                                var5 -= 2;
                                                var20 = class38.field823[var5];
                                                var21 = class38.field823[var5 + 1];
                                                class38.field823[var5++] = var20 | var21;
                                                continue;
                                             }

                                             if(var16 == 4018) {
                                                var5 -= 3;
                                                var81 = (long)class38.field823[var5];
                                                var77 = (long)class38.field823[1 + var5];
                                                long var76 = (long)class38.field823[2 + var5];
                                                class38.field823[var5++] = (int)(var81 * var76 / var77);
                                                continue;
                                             }
                                          } else if(var16 < 4200) {
                                             if(var16 == 4100) {
                                                --var6;
                                                var24 = class38.chatboxSegments[var6];
                                                --var5;
                                                var21 = class38.field823[var5];
                                                class38.chatboxSegments[var6++] = var24 + var21;
                                                continue;
                                             }

                                             if(var16 == 4101) {
                                                var6 -= 2;
                                                var24 = class38.chatboxSegments[var6];
                                                var56 = class38.chatboxSegments[var6 + 1];
                                                class38.chatboxSegments[var6++] = var24 + var56;
                                                continue;
                                             }

                                             if(var16 == 4102) {
                                                --var6;
                                                var24 = class38.chatboxSegments[var6];
                                                --var5;
                                                var21 = class38.field823[var5];
                                                class38.chatboxSegments[var6++] = var24 + class21.method583(var21, true);
                                                continue;
                                             }

                                             if(var16 == 4103) {
                                                --var6;
                                                var24 = class38.chatboxSegments[var6];
                                                class38.chatboxSegments[var6++] = var24.toLowerCase();
                                                continue;
                                             }

                                             if(var16 == 4104) {
                                                --var5;
                                                var20 = class38.field823[var5];
                                                var81 = 86400000L * ((long)var20 + 11745L);
                                                class38.field827.setTime(new Date(var81));
                                                var22 = class38.field827.get(5);
                                                var23 = class38.field827.get(2);
                                                var27 = class38.field827.get(1);
                                                class38.chatboxSegments[var6++] = var22 + "-" + class38.field826[var23] + "-" + var27;
                                                continue;
                                             }

                                             if(var16 == 4105) {
                                                var6 -= 2;
                                                var24 = class38.chatboxSegments[var6];
                                                var56 = class38.chatboxSegments[var6 + 1];
                                                if(WidgetNode.localPlayer.composition != null && WidgetNode.localPlayer.composition.isFemale) {
                                                   class38.chatboxSegments[var6++] = var56;
                                                   continue;
                                                }

                                                class38.chatboxSegments[var6++] = var24;
                                                continue;
                                             }

                                             if(var16 == 4106) {
                                                --var5;
                                                var20 = class38.field823[var5];
                                                class38.chatboxSegments[var6++] = Integer.toString(var20);
                                                continue;
                                             }

                                             if(var16 == 4107) {
                                                var6 -= 2;
                                                int[] var83 = class38.field823;
                                                var21 = var5++;
                                                var22 = class40.method811(class38.chatboxSegments[var6], class38.chatboxSegments[1 + var6], Client.field326);
                                                if(var22 > 0) {
                                                   var28 = 1;
                                                } else if(var22 < 0) {
                                                   var28 = -1;
                                                } else {
                                                   var28 = 0;
                                                }

                                                var83[var21] = var28;
                                                continue;
                                             }

                                             class227 var82;
                                             byte[] var88;
                                             if(var16 == 4108) {
                                                --var6;
                                                var24 = class38.chatboxSegments[var6];
                                                var5 -= 2;
                                                var21 = class38.field823[var5];
                                                var26 = class38.field823[var5 + 1];
                                                var88 = Tile.field1811.method3411(var26, 0);
                                                var82 = new class227(var88);
                                                class38.field823[var5++] = var82.method4168(var24, var21);
                                                continue;
                                             }

                                             if(var16 == 4109) {
                                                --var6;
                                                var24 = class38.chatboxSegments[var6];
                                                var5 -= 2;
                                                var21 = class38.field823[var5];
                                                var26 = class38.field823[1 + var5];
                                                var88 = Tile.field1811.method3411(var26, 0);
                                                var82 = new class227(var88);
                                                class38.field823[var5++] = var82.method4167(var24, var21);
                                                continue;
                                             }

                                             if(var16 == 4110) {
                                                var6 -= 2;
                                                var24 = class38.chatboxSegments[var6];
                                                var56 = class38.chatboxSegments[var6 + 1];
                                                --var5;
                                                if(class38.field823[var5] == 1) {
                                                   class38.chatboxSegments[var6++] = var24;
                                                } else {
                                                   class38.chatboxSegments[var6++] = var56;
                                                }
                                                continue;
                                             }

                                             if(var16 == 4111) {
                                                --var6;
                                                var24 = class38.chatboxSegments[var6];
                                                class38.chatboxSegments[var6++] = class226.method4169(var24);
                                                continue;
                                             }

                                             if(var16 == 4112) {
                                                --var6;
                                                var24 = class38.chatboxSegments[var6];
                                                --var5;
                                                var21 = class38.field823[var5];
                                                class38.chatboxSegments[var6++] = var24 + (char)var21;
                                                continue;
                                             }

                                             char var78;
                                             if(var16 == 4113) {
                                                --var5;
                                                var20 = class38.field823[var5];
                                                var25 = class38.field823;
                                                var26 = var5++;
                                                var78 = (char)var20;
                                                if(var78 >= 32 && var78 <= 126) {
                                                   var32 = true;
                                                } else if(var78 >= 160 && var78 <= 255) {
                                                   var32 = true;
                                                } else if(var78 != 8364 && var78 != 338 && var78 != 8212 && var78 != 339 && var78 != 376) {
                                                   var32 = false;
                                                } else {
                                                   var32 = true;
                                                }

                                                var25[var26] = var32?1:0;
                                                continue;
                                             }

                                             if(var16 == 4114) {
                                                --var5;
                                                var20 = class38.field823[var5];
                                                class38.field823[var5++] = ItemLayer.method2290((char)var20)?1:0;
                                                continue;
                                             }

                                             if(var16 == 4115) {
                                                --var5;
                                                var20 = class38.field823[var5];
                                                class38.field823[var5++] = class35.method758((char)var20)?1:0;
                                                continue;
                                             }

                                             if(var16 == 4116) {
                                                --var5;
                                                var20 = class38.field823[var5];
                                                class38.field823[var5++] = class40.method812((char)var20)?1:0;
                                                continue;
                                             }

                                             if(var16 == 4117) {
                                                --var6;
                                                var24 = class38.chatboxSegments[var6];
                                                if(null != var24) {
                                                   class38.field823[var5++] = var24.length();
                                                } else {
                                                   class38.field823[var5++] = 0;
                                                }
                                                continue;
                                             }

                                             if(var16 == 4118) {
                                                --var6;
                                                var24 = class38.chatboxSegments[var6];
                                                var5 -= 2;
                                                var21 = class38.field823[var5];
                                                var26 = class38.field823[1 + var5];
                                                class38.chatboxSegments[var6++] = var24.substring(var21, var26);
                                                continue;
                                             }

                                             if(var16 == 4119) {
                                                --var6;
                                                var24 = class38.chatboxSegments[var6];
                                                StringBuilder var47 = new StringBuilder(var24.length());
                                                var36 = false;

                                                for(var22 = 0; var22 < var24.length(); ++var22) {
                                                   var78 = var24.charAt(var22);
                                                   if(var78 == 60) {
                                                      var36 = true;
                                                   } else if(var78 == 62) {
                                                      var36 = false;
                                                   } else if(!var36) {
                                                      var47.append(var78);
                                                   }
                                                }

                                                class38.chatboxSegments[var6++] = var47.toString();
                                                continue;
                                             }

                                             if(var16 == 4120) {
                                                --var6;
                                                var24 = class38.chatboxSegments[var6];
                                                --var5;
                                                var21 = class38.field823[var5];
                                                class38.field823[var5++] = var24.indexOf(var21);
                                                continue;
                                             }

                                             if(var16 == 4121) {
                                                var6 -= 2;
                                                var24 = class38.chatboxSegments[var6];
                                                var56 = class38.chatboxSegments[var6 + 1];
                                                --var5;
                                                var26 = class38.field823[var5];
                                                class38.field823[var5++] = var24.indexOf(var56, var26);
                                                continue;
                                             }
                                          } else if(var16 < 4300) {
                                             if(var16 == 4200) {
                                                --var5;
                                                var20 = class38.field823[var5];
                                                class38.chatboxSegments[var6++] = class1.getItemDefinition(var20).name;
                                                continue;
                                             }

                                             ItemComposition var84;
                                             if(var16 == 4201) {
                                                var5 -= 2;
                                                var20 = class38.field823[var5];
                                                var21 = class38.field823[var5 + 1];
                                                var84 = class1.getItemDefinition(var20);
                                                if(var21 >= 1 && var21 <= 5 && var84.groundActions[var21 - 1] != null) {
                                                   class38.chatboxSegments[var6++] = var84.groundActions[var21 - 1];
                                                   continue;
                                                }

                                                class38.chatboxSegments[var6++] = "";
                                                continue;
                                             }

                                             if(var16 == 4202) {
                                                var5 -= 2;
                                                var20 = class38.field823[var5];
                                                var21 = class38.field823[var5 + 1];
                                                var84 = class1.getItemDefinition(var20);
                                                if(var21 >= 1 && var21 <= 5 && null != var84.inventoryActions[var21 - 1]) {
                                                   class38.chatboxSegments[var6++] = var84.inventoryActions[var21 - 1];
                                                   continue;
                                                }

                                                class38.chatboxSegments[var6++] = "";
                                                continue;
                                             }

                                             if(var16 == 4203) {
                                                --var5;
                                                var20 = class38.field823[var5];
                                                class38.field823[var5++] = class1.getItemDefinition(var20).price;
                                                continue;
                                             }

                                             if(var16 == 4204) {
                                                --var5;
                                                var20 = class38.field823[var5];
                                                class38.field823[var5++] = class1.getItemDefinition(var20).isStackable == 1?1:0;
                                                continue;
                                             }

                                             ItemComposition var89;
                                             if(var16 == 4205) {
                                                --var5;
                                                var20 = class38.field823[var5];
                                                var89 = class1.getItemDefinition(var20);
                                                if(var89.field1178 == -1 && var89.note >= 0) {
                                                   class38.field823[var5++] = var89.note;
                                                   continue;
                                                }

                                                class38.field823[var5++] = var20;
                                                continue;
                                             }

                                             if(var16 == 4206) {
                                                --var5;
                                                var20 = class38.field823[var5];
                                                var89 = class1.getItemDefinition(var20);
                                                if(var89.field1178 >= 0 && var89.note >= 0) {
                                                   class38.field823[var5++] = var89.note;
                                                   continue;
                                                }

                                                class38.field823[var5++] = var20;
                                                continue;
                                             }

                                             if(var16 == 4207) {
                                                --var5;
                                                var20 = class38.field823[var5];
                                                class38.field823[var5++] = class1.getItemDefinition(var20).isMembers?1:0;
                                                continue;
                                             }

                                             if(var16 == 4208) {
                                                --var5;
                                                var20 = class38.field823[var5];
                                                var89 = class1.getItemDefinition(var20);
                                                if(var89.field1213 == -1 && var89.field1227 >= 0) {
                                                   class38.field823[var5++] = var89.field1227;
                                                   continue;
                                                }

                                                class38.field823[var5++] = var20;
                                                continue;
                                             }

                                             if(var16 == 4209) {
                                                --var5;
                                                var20 = class38.field823[var5];
                                                var89 = class1.getItemDefinition(var20);
                                                if(var89.field1213 >= 0 && var89.field1227 >= 0) {
                                                   class38.field823[var5++] = var89.field1227;
                                                   continue;
                                                }

                                                class38.field823[var5++] = var20;
                                                continue;
                                             }

                                             if(var16 == 4210) {
                                                --var6;
                                                var24 = class38.chatboxSegments[var6];
                                                --var5;
                                                var21 = class38.field823[var5];
                                                class4.method50(var24, var21 == 1);
                                                class38.field823[var5++] = SecondaryBufferProvider.field1452;
                                                continue;
                                             }

                                             if(var16 == 4211) {
                                                if(class8.field151 != null && class110.field1954 < SecondaryBufferProvider.field1452) {
                                                   class38.field823[var5++] = class8.field151[++class110.field1954 - 1] & '\uffff';
                                                   continue;
                                                }

                                                class38.field823[var5++] = -1;
                                                continue;
                                             }

                                             if(var16 == 4212) {
                                                class110.field1954 = 0;
                                                continue;
                                             }
                                          } else if(var16 < 5100) {
                                             if(var16 == 5000) {
                                                class38.field823[var5++] = Client.field511;
                                                continue;
                                             }

                                             if(var16 == 5001) {
                                                var5 -= 3;
                                                Client.field511 = class38.field823[var5];
                                                var21 = class38.field823[1 + var5];
                                                class133[] var94 = new class133[]{class133.field2110, class133.field2108, class133.field2107};
                                                class133[] var92 = var94;
                                                var23 = 0;

                                                class133 var79;
                                                while(true) {
                                                   if(var23 >= var92.length) {
                                                      var79 = null;
                                                      break;
                                                   }

                                                   class133 var80 = var92[var23];
                                                   if(var21 == var80.field2109) {
                                                      var79 = var80;
                                                      break;
                                                   }

                                                   ++var23;
                                                }

                                                ChatLineBuffer.field706 = var79;
                                                if(null == ChatLineBuffer.field706) {
                                                   ChatLineBuffer.field706 = class133.field2107;
                                                }

                                                Client.field379 = class38.field823[2 + var5];
                                                Client.field337.method2903(145);
                                                Client.field337.method2783(Client.field511);
                                                Client.field337.method2783(ChatLineBuffer.field706.field2109);
                                                Client.field337.method2783(Client.field379);
                                                continue;
                                             }

                                             if(var16 == 5002) {
                                                --var6;
                                                var24 = class38.chatboxSegments[var6];
                                                var5 -= 2;
                                                var21 = class38.field823[var5];
                                                var26 = class38.field823[var5 + 1];
                                                Client.field337.method2903(128);
                                                Client.field337.method2783(class54.method1165(var24) + 2);
                                                Client.field337.method2703(var24);
                                                Client.field337.method2783(var21 - 1);
                                                Client.field337.method2783(var26);
                                                continue;
                                             }

                                             MessageNode var85;
                                             if(var16 == 5003) {
                                                var5 -= 2;
                                                var20 = class38.field823[var5];
                                                var21 = class38.field823[var5 + 1];
                                                var85 = Sequence.method939(var20, var21);
                                                if(null != var85) {
                                                   class38.field823[var5++] = var85.id;
                                                   class38.field823[var5++] = var85.tick;
                                                   class38.chatboxSegments[var6++] = null != var85.name?var85.name:"";
                                                   class38.chatboxSegments[var6++] = var85.sender != null?var85.sender:"";
                                                   class38.chatboxSegments[var6++] = null != var85.value?var85.value:"";
                                                } else {
                                                   class38.field823[var5++] = -1;
                                                   class38.field823[var5++] = 0;
                                                   class38.chatboxSegments[var6++] = "";
                                                   class38.chatboxSegments[var6++] = "";
                                                   class38.chatboxSegments[var6++] = "";
                                                }
                                                continue;
                                             }

                                             if(var16 == 5004) {
                                                --var5;
                                                var20 = class38.field823[var5];
                                                var85 = class118.method2569(var20);
                                                if(var85 != null) {
                                                   class38.field823[var5++] = var85.type;
                                                   class38.field823[var5++] = var85.tick;
                                                   class38.chatboxSegments[var6++] = null != var85.name?var85.name:"";
                                                   class38.chatboxSegments[var6++] = null != var85.sender?var85.sender:"";
                                                   class38.chatboxSegments[var6++] = null != var85.value?var85.value:"";
                                                } else {
                                                   class38.field823[var5++] = -1;
                                                   class38.field823[var5++] = 0;
                                                   class38.chatboxSegments[var6++] = "";
                                                   class38.chatboxSegments[var6++] = "";
                                                   class38.chatboxSegments[var6++] = "";
                                                }
                                                continue;
                                             }

                                             if(var16 == 5005) {
                                                if(ChatLineBuffer.field706 == null) {
                                                   class38.field823[var5++] = -1;
                                                } else {
                                                   class38.field823[var5++] = ChatLineBuffer.field706.field2109;
                                                }
                                                continue;
                                             }

                                             if(var16 == 5008) {
                                                --var6;
                                                var24 = class38.chatboxSegments[var6];
                                                --var5;
                                                var21 = class38.field823[var5];
                                                var17 = var24.toLowerCase();
                                                byte var86 = 0;
                                                if(var17.startsWith("yellow:")) {
                                                   var86 = 0;
                                                   var24 = var24.substring("yellow:".length());
                                                } else if(var17.startsWith("red:")) {
                                                   var86 = 1;
                                                   var24 = var24.substring("red:".length());
                                                } else if(var17.startsWith("green:")) {
                                                   var86 = 2;
                                                   var24 = var24.substring("green:".length());
                                                } else if(var17.startsWith("cyan:")) {
                                                   var86 = 3;
                                                   var24 = var24.substring("cyan:".length());
                                                } else if(var17.startsWith("purple:")) {
                                                   var86 = 4;
                                                   var24 = var24.substring("purple:".length());
                                                } else if(var17.startsWith("white:")) {
                                                   var86 = 5;
                                                   var24 = var24.substring("white:".length());
                                                } else if(var17.startsWith("flash1:")) {
                                                   var86 = 6;
                                                   var24 = var24.substring("flash1:".length());
                                                } else if(var17.startsWith("flash2:")) {
                                                   var86 = 7;
                                                   var24 = var24.substring("flash2:".length());
                                                } else if(var17.startsWith("flash3:")) {
                                                   var86 = 8;
                                                   var24 = var24.substring("flash3:".length());
                                                } else if(var17.startsWith("glow1:")) {
                                                   var86 = 9;
                                                   var24 = var24.substring("glow1:".length());
                                                } else if(var17.startsWith("glow2:")) {
                                                   var86 = 10;
                                                   var24 = var24.substring("glow2:".length());
                                                } else if(var17.startsWith("glow3:")) {
                                                   var86 = 11;
                                                   var24 = var24.substring("glow3:".length());
                                                } else if(Client.field326 != 0) {
                                                   if(var17.startsWith("yellow:")) {
                                                      var86 = 0;
                                                      var24 = var24.substring("yellow:".length());
                                                   } else if(var17.startsWith("red:")) {
                                                      var86 = 1;
                                                      var24 = var24.substring("red:".length());
                                                   } else if(var17.startsWith("green:")) {
                                                      var86 = 2;
                                                      var24 = var24.substring("green:".length());
                                                   } else if(var17.startsWith("cyan:")) {
                                                      var86 = 3;
                                                      var24 = var24.substring("cyan:".length());
                                                   } else if(var17.startsWith("purple:")) {
                                                      var86 = 4;
                                                      var24 = var24.substring("purple:".length());
                                                   } else if(var17.startsWith("white:")) {
                                                      var86 = 5;
                                                      var24 = var24.substring("white:".length());
                                                   } else if(var17.startsWith("flash1:")) {
                                                      var86 = 6;
                                                      var24 = var24.substring("flash1:".length());
                                                   } else if(var17.startsWith("flash2:")) {
                                                      var86 = 7;
                                                      var24 = var24.substring("flash2:".length());
                                                   } else if(var17.startsWith("flash3:")) {
                                                      var86 = 8;
                                                      var24 = var24.substring("flash3:".length());
                                                   } else if(var17.startsWith("glow1:")) {
                                                      var86 = 9;
                                                      var24 = var24.substring("glow1:".length());
                                                   } else if(var17.startsWith("glow2:")) {
                                                      var86 = 10;
                                                      var24 = var24.substring("glow2:".length());
                                                   } else if(var17.startsWith("glow3:")) {
                                                      var86 = 11;
                                                      var24 = var24.substring("glow3:".length());
                                                   }
                                                }

                                                var17 = var24.toLowerCase();
                                                byte var90 = 0;
                                                if(var17.startsWith("wave:")) {
                                                   var90 = 1;
                                                   var24 = var24.substring("wave:".length());
                                                } else if(var17.startsWith("wave2:")) {
                                                   var90 = 2;
                                                   var24 = var24.substring("wave2:".length());
                                                } else if(var17.startsWith("shake:")) {
                                                   var90 = 3;
                                                   var24 = var24.substring("shake:".length());
                                                } else if(var17.startsWith("scroll:")) {
                                                   var90 = 4;
                                                   var24 = var24.substring("scroll:".length());
                                                } else if(var17.startsWith("slide:")) {
                                                   var90 = 5;
                                                   var24 = var24.substring("slide:".length());
                                                } else if(Client.field326 != 0) {
                                                   if(var17.startsWith("wave:")) {
                                                      var90 = 1;
                                                      var24 = var24.substring("wave:".length());
                                                   } else if(var17.startsWith("wave2:")) {
                                                      var90 = 2;
                                                      var24 = var24.substring("wave2:".length());
                                                   } else if(var17.startsWith("shake:")) {
                                                      var90 = 3;
                                                      var24 = var24.substring("shake:".length());
                                                   } else if(var17.startsWith("scroll:")) {
                                                      var90 = 4;
                                                      var24 = var24.substring("scroll:".length());
                                                   } else if(var17.startsWith("slide:")) {
                                                      var90 = 5;
                                                      var24 = var24.substring("slide:".length());
                                                   }
                                                }

                                                Client.field337.method2903(1);
                                                Client.field337.method2783(0);
                                                var27 = Client.field337.offset;
                                                Client.field337.method2783(var21);
                                                Client.field337.method2783(var86);
                                                Client.field337.method2783(var90);
                                                Actor.method809(Client.field337, var24);
                                                Client.field337.method2671(Client.field337.offset - var27);
                                                continue;
                                             }

                                             if(var16 == 5009) {
                                                var6 -= 2;
                                                var24 = class38.chatboxSegments[var6];
                                                var56 = class38.chatboxSegments[1 + var6];
                                                Client.field337.method2903(104);
                                                Client.field337.method2619(0);
                                                var26 = Client.field337.offset;
                                                Client.field337.method2703(var24);
                                                Actor.method809(Client.field337, var56);
                                                Client.field337.method2629(Client.field337.offset - var26);
                                                continue;
                                             }

                                             if(var16 == 5015) {
                                                if(null != WidgetNode.localPlayer && null != WidgetNode.localPlayer.name) {
                                                   var24 = WidgetNode.localPlayer.name;
                                                } else {
                                                   var24 = "";
                                                }

                                                class38.chatboxSegments[var6++] = var24;
                                                continue;
                                             }

                                             if(var16 == 5016) {
                                                class38.field823[var5++] = Client.field379;
                                                continue;
                                             }

                                             if(var16 == 5017) {
                                                --var5;
                                                var20 = class38.field823[var5];
                                                class38.field823[var5++] = Item.method687(var20);
                                                continue;
                                             }

                                             if(var16 == 5018) {
                                                --var5;
                                                var20 = class38.field823[var5];
                                                var25 = class38.field823;
                                                var26 = var5++;
                                                var85 = (MessageNode)class11.field174.method3950((long)var20);
                                                if(var85 == null) {
                                                   var22 = -1;
                                                } else if(class11.field173.field3158 == var85.previous) {
                                                   var22 = -1;
                                                } else {
                                                   var22 = ((MessageNode)var85.previous).id;
                                                }

                                                var25[var26] = var22;
                                                continue;
                                             }

                                             if(var16 == 5019) {
                                                --var5;
                                                var20 = class38.field823[var5];
                                                class38.field823[var5++] = NPC.method774(var20);
                                                continue;
                                             }

                                             if(var16 == 5020) {
                                                --var6;
                                                var24 = class38.chatboxSegments[var6];
                                                class79.method1754(var24);
                                                continue;
                                             }

                                             if(var16 == 5021) {
                                                --var6;
                                                Client.field415 = class38.chatboxSegments[var6].toLowerCase().trim();
                                                continue;
                                             }

                                             if(var16 == 5022) {
                                                class38.chatboxSegments[var6++] = Client.field415;
                                                continue;
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           } else {
                              if(var16 >= 2000) {
                                 var16 -= 1000;
                                 --var5;
                                 var30 = class134.method2983(class38.field823[var5]);
                              } else {
                                 var30 = var29?class18.field266:class50.field1122;
                              }

                              if(var16 == 1927) {
                                 if(class38.field829 >= 10) {
                                    throw new RuntimeException();
                                 }

                                 if(null == var30.field2916) {
                                    return;
                                 }

                                 class0 var38 = new class0();
                                 var38.field2 = var30;
                                 var38.field8 = var30.field2916;
                                 var38.field10 = class38.field829 + 1;
                                 Client.field353.method3963(var0);
                                 continue;
                              }
                           }
                        }
                     } else {
                        if(var16 >= 2000) {
                           var16 -= 1000;
                           --var5;
                           var30 = class134.method2983(class38.field823[var5]);
                        } else {
                           var30 = var29?class18.field266:class50.field1122;
                        }

                        class79.method1777(var30);
                        if(var16 == 1200 || var16 == 1205 || var16 == 1212) {
                           var5 -= 2;
                           var21 = class38.field823[var5];
                           var26 = class38.field823[1 + var5];
                           var30.item = var21;
                           var30.stackSize = var26;
                           ItemComposition var37 = class1.getItemDefinition(var21);
                           var30.rotationX = var37.field1188;
                           var30.rotationZ = var37.field1193;
                           var30.rotationY = var37.field1194;
                           var30.field2856 = var37.field1179;
                           var30.field2857 = var37.field1196;
                           var30.field2933 = var37.field1191;
                           if(var16 == 1205) {
                              var30.field2865 = 0;
                           } else if(var16 == 1212 | var37.isStackable == 1) {
                              var30.field2865 = 1;
                           } else {
                              var30.field2865 = 2;
                           }

                           if(var30.field2862 > 0) {
                              var30.field2933 = var30.field2933 * 32 / var30.field2862;
                           } else if(var30.field2818 > 0) {
                              var30.field2933 = var30.field2933 * 32 / var30.field2818;
                           }
                           continue;
                        }

                        if(var16 == 1201) {
                           var30.modelType = 2;
                           --var5;
                           var30.modelId = class38.field823[var5];
                           continue;
                        }

                        if(var16 == 1202) {
                           var30.modelType = 3;
                           var30.modelId = WidgetNode.localPlayer.composition.method3642();
                           continue;
                        }
                     }
                  } else {
                     var20 = -1;
                     if(var16 >= 2000) {
                        var16 -= 1000;
                        --var5;
                        var20 = class38.field823[var5];
                        var31 = class134.method2983(var20);
                     } else {
                        var31 = var29?class18.field266:class50.field1122;
                     }

                     if(var16 == 1000) {
                        var5 -= 4;
                        var31.field2816 = class38.field823[var5];
                        var31.field2941 = class38.field823[1 + var5];
                        var31.field2812 = class38.field823[2 + var5];
                        var31.field2925 = class38.field823[var5 + 3];
                        class79.method1777(var31);
                        class8.method117(var31);
                        if(var20 != -1 && var31.type == 0) {
                           class53.method1145(Widget.widgets[var20 >> 16], var31, false);
                        }
                        continue;
                     }

                     if(var16 == 1001) {
                        var5 -= 4;
                        var31.field2818 = class38.field823[var5];
                        var31.field2819 = class38.field823[1 + var5];
                        var31.field2806 = class38.field823[var5 + 2];
                        var31.field2815 = class38.field823[var5 + 3];
                        class79.method1777(var31);
                        class8.method117(var31);
                        if(var20 != -1 && var31.type == 0) {
                           class53.method1145(Widget.widgets[var20 >> 16], var31, false);
                        }
                        continue;
                     }

                     if(var16 == 1003) {
                        --var5;
                        var36 = class38.field823[var5] == 1;
                        if(var36 != var31.isHidden) {
                           var31.isHidden = var36;
                           class79.method1777(var31);
                        }
                        continue;
                     }

                     if(var16 == 1005) {
                        --var5;
                        var31.field2940 = class38.field823[var5] == 1;
                        continue;
                     }

                     if(var16 == 1006) {
                        --var5;
                        var31.field2913 = class38.field823[var5] == 1;
                        continue;
                     }
                  }
               }

               if(var16 < 5400) {
                  if(var16 == 5306) {
                     class38.field823[var5++] = class53.method1139();
                     continue;
                  }

                  if(var16 == 5307) {
                     --var5;
                     var20 = class38.field823[var5];
                     if(var20 != 1 && var20 != 2) {
                        continue;
                     }

                     Client.field352 = 0L;
                     if(var20 >= 2) {
                        Client.isResized = true;
                     } else {
                        Client.isResized = false;
                     }

                     class10.method143();
                     if(Client.gameState >= 25) {
                        Projectile.method103();
                     }

                     GameEngine.field2263 = true;
                     continue;
                  }

                  if(var16 == 5308) {
                     class38.field823[var5++] = class136.field2123.field146;
                     continue;
                  }

                  if(var16 == 5309) {
                     --var5;
                     var20 = class38.field823[var5];
                     if(var20 == 1 || var20 == 2) {
                        class136.field2123.field146 = var20;
                        ObjectComposition.method886();
                     }
                     continue;
                  }
               }

               if(var16 < 5600) {
                  if(var16 == 5504) {
                     var5 -= 2;
                     var20 = class38.field823[var5];
                     var21 = class38.field823[1 + var5];
                     if(!Client.field542) {
                        Client.field462 = var20;
                        Client.mapAngle = var21;
                     }
                     continue;
                  }

                  if(var16 == 5505) {
                     class38.field823[var5++] = Client.field462;
                     continue;
                  }

                  if(var16 == 5506) {
                     class38.field823[var5++] = Client.mapAngle;
                     continue;
                  }

                  if(var16 == 5530) {
                     --var5;
                     var20 = class38.field823[var5];
                     if(var20 < 0) {
                        var20 = 0;
                     }

                     Client.field338 = var20;
                     continue;
                  }

                  if(var16 == 5531) {
                     class38.field823[var5++] = Client.field338;
                     continue;
                  }
               }

               if(var16 < 5700 && var16 == 5630) {
                  Client.field299 = 250;
               } else {
                  if(var16 < 6300) {
                     if(var16 == 6200) {
                        var5 -= 2;
                        Client.field548 = (short)class38.field823[var5];
                        if(Client.field548 <= 0) {
                           Client.field548 = 256;
                        }

                        Client.field549 = (short)class38.field823[1 + var5];
                        if(Client.field549 <= 0) {
                           Client.field549 = 205;
                        }
                        continue;
                     }

                     if(var16 == 6201) {
                        var5 -= 2;
                        Client.field359 = (short)class38.field823[var5];
                        if(Client.field359 <= 0) {
                           Client.field359 = 256;
                        }

                        Client.field551 = (short)class38.field823[1 + var5];
                        if(Client.field551 <= 0) {
                           Client.field551 = 320;
                        }
                        continue;
                     }

                     if(var16 == 6202) {
                        var5 -= 4;
                        Client.field552 = (short)class38.field823[var5];
                        if(Client.field552 <= 0) {
                           Client.field552 = 1;
                        }

                        Client.field492 = (short)class38.field823[1 + var5];
                        if(Client.field492 <= 0) {
                           Client.field492 = 32767;
                        } else if(Client.field492 < Client.field552) {
                           Client.field492 = Client.field552;
                        }

                        Client.field320 = (short)class38.field823[2 + var5];
                        if(Client.field320 <= 0) {
                           Client.field320 = 1;
                        }

                        Client.field563 = (short)class38.field823[var5 + 3];
                        if(Client.field563 <= 0) {
                           Client.field563 = 32767;
                        } else if(Client.field563 < Client.field320) {
                           Client.field563 = Client.field320;
                        }
                        continue;
                     }

                     if(var16 == 6203) {
                        if(Client.field465 != null) {
                           class110.method2487(0, 0, Client.field465.width, Client.field465.height, false);
                           class38.field823[var5++] = Client.camera2;
                           class38.field823[var5++] = Client.camera3;
                        } else {
                           class38.field823[var5++] = -1;
                           class38.field823[var5++] = -1;
                        }
                        continue;
                     }

                     if(var16 == 6204) {
                        class38.field823[var5++] = Client.field359;
                        class38.field823[var5++] = Client.field551;
                        continue;
                     }

                     if(var16 == 6205) {
                        class38.field823[var5++] = Client.field548;
                        class38.field823[var5++] = Client.field549;
                        continue;
                     }
                  }

                  if(var16 < 6600) {
                     if(var16 == 6500) {
                        class38.field823[var5++] = Player.loadWorlds()?1:0;
                        continue;
                     }

                     World var55;
                     if(var16 == 6501) {
                        var55 = class157.method3301();
                        if(var55 != null) {
                           class38.field823[var5++] = var55.id;
                           class38.field823[var5++] = var55.mask;
                           class38.chatboxSegments[var6++] = var55.activity;
                           class38.field823[var5++] = var55.location;
                           class38.field823[var5++] = var55.playerCount;
                           class38.chatboxSegments[var6++] = var55.address;
                        } else {
                           class38.field823[var5++] = -1;
                           class38.field823[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                           class38.field823[var5++] = 0;
                           class38.field823[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var16 == 6502) {
                        if(World.field664 < World.field663) {
                           var55 = World.worldList[++World.field664 - 1];
                        } else {
                           var30 = null;
                        }

                        class38.field823[var5++] = -1;
                        class38.field823[var5++] = 0;
                        class38.chatboxSegments[var6++] = "";
                        class38.field823[var5++] = 0;
                        class38.field823[var5++] = 0;
                        class38.chatboxSegments[var6++] = "";
                        continue;
                     }

                     World var64;
                     if(var16 == 6506) {
                        --var5;
                        var20 = class38.field823[var5];
                        var64 = null;

                        for(var26 = 0; var26 < World.field663; ++var26) {
                           if(var20 == World.worldList[var26].id) {
                              var64 = World.worldList[var26];
                              break;
                           }
                        }

                        if(null != var64) {
                           class38.field823[var5++] = var64.id;
                           class38.field823[var5++] = var64.mask;
                           class38.chatboxSegments[var6++] = var64.activity;
                           class38.field823[var5++] = var64.location;
                           class38.field823[var5++] = var64.playerCount;
                           class38.chatboxSegments[var6++] = var64.address;
                        } else {
                           class38.field823[var5++] = -1;
                           class38.field823[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                           class38.field823[var5++] = 0;
                           class38.field823[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var16 == 6507) {
                        var5 -= 4;
                        var20 = class38.field823[var5];
                        var35 = class38.field823[1 + var5] == 1;
                        var26 = class38.field823[var5 + 2];
                        var32 = class38.field823[var5 + 3] == 1;
                        class28.method666(var20, var35, var26, var32);
                        continue;
                     }

                     if(var16 == 6511) {
                        --var5;
                        var20 = class38.field823[var5];
                        if(var20 >= 0 && var20 < World.field663) {
                           var64 = World.worldList[var20];
                           class38.field823[var5++] = var64.id;
                           class38.field823[var5++] = var64.mask;
                           class38.chatboxSegments[var6++] = var64.activity;
                           class38.field823[var5++] = var64.location;
                           class38.field823[var5++] = var64.playerCount;
                           class38.chatboxSegments[var6++] = var64.address;
                           continue;
                        }

                        class38.field823[var5++] = -1;
                        class38.field823[var5++] = 0;
                        class38.chatboxSegments[var6++] = "";
                        class38.field823[var5++] = 0;
                        class38.field823[var5++] = 0;
                        class38.chatboxSegments[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var48) {
            StringBuilder var13 = new StringBuilder(30);
            var13.append("").append(var4.hash).append(" ");

            for(var11 = class38.field825 - 1; var11 >= 0; --var11) {
               var13.append("").append(class38.field828[var11].field219.hash).append(" ");
            }

            var13.append("").append(var10);
            class13.method176(var13.toString(), var48);
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-54"
   )
   static final void method2283() {
      Client.field564 = 0;
      int var0 = (WidgetNode.localPlayer.x >> 7) + class0.baseX;
      int var1 = class21.baseY + (WidgetNode.localPlayer.y >> 7);
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field564 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field564 = 1;
      }

      if(Client.field564 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field564 = 0;
      }

   }
}
