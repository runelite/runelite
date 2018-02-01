import java.util.Arrays;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ja")
@Implements("NameableContainer")
public abstract class NameableContainer {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 777467825
   )
   final int field3685;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -65853015
   )
   @Export("count")
   int count;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[Lju;"
   )
   @Export("nameables")
   Nameable[] nameables;
   @ObfuscatedName("t")
   HashMap field3686;
   @ObfuscatedName("r")
   HashMap field3683;

   NameableContainer(int var1) {
      this.count = 0;
      this.field3685 = var1;
      this.nameables = this.vmethod5161(var1);
      this.field3686 = new HashMap(var1 / 8);
      this.field3683 = new HashMap(var1 / 8);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lju;",
      garbageValue = "-98"
   )
   abstract Nameable vmethod5160();

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)[Lju;",
      garbageValue = "-1319508722"
   )
   abstract Nameable[] vmethod5161(int var1);

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-111"
   )
   public void method5067() {
      this.count = 0;
      Arrays.fill(this.nameables, (Object)null);
      this.field3686.clear();
      this.field3683.clear();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-48"
   )
   @Export("getCount")
   public int getCount() {
      return this.count;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1646413875"
   )
   public boolean method5037() {
      return this.count == this.field3685;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljr;I)Z",
      garbageValue = "1705599167"
   )
   @Export("isMember")
   public boolean isMember(Name var1) {
      return !var1.method5132()?false:(this.field3686.containsKey(var1)?true:this.field3683.containsKey(var1));
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljr;B)Lju;",
      garbageValue = "-20"
   )
   Nameable method5039(Name var1) {
      Nameable var2 = this.method5040(var1);
      return var2 != null?var2:this.method5041(var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljr;I)Lju;",
      garbageValue = "1795987005"
   )
   Nameable method5040(Name var1) {
      return !var1.method5132()?null:(Nameable)this.field3686.get(var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljr;I)Lju;",
      garbageValue = "-746659853"
   )
   Nameable method5041(Name var1) {
      return !var1.method5132()?null:(Nameable)this.field3683.get(var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljr;B)Z",
      garbageValue = "84"
   )
   public final boolean method5056(Name var1) {
      Nameable var2 = this.method5040(var1);
      if(var2 == null) {
         return false;
      } else {
         this.method5043(var2);
         return true;
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Lju;I)V",
      garbageValue = "339800791"
   )
   final void method5043(Nameable var1) {
      int var2 = this.method5049(var1);
      if(var2 != -1) {
         this.method5057(var2);
         this.method5050(var1);
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Ljr;B)Lju;",
      garbageValue = "46"
   )
   Nameable method5034(Name var1) {
      return this.method5045(var1, (Name)null);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Ljr;Ljr;I)Lju;",
      garbageValue = "196391872"
   )
   Nameable method5045(Name var1, Name var2) {
      if(this.method5039(var1) != null) {
         throw new IllegalStateException();
      } else {
         Nameable var3 = this.vmethod5160();
         var3.method5017(var1, var2);
         this.method5081(var3);
         this.method5052(var3);
         return var3;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IB)Lju;",
      garbageValue = "-5"
   )
   @Export("get")
   public final Nameable get(int var1) {
      if(var1 >= 0 && var1 < this.count) {
         return this.nameables[var1];
      } else {
         throw new ArrayIndexOutOfBoundsException();
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1496239280"
   )
   public final void method5047() {
      Arrays.sort(this.nameables, 0, this.count);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Lju;Ljr;Ljr;S)V",
      garbageValue = "600"
   )
   final void method5042(Nameable var1, Name var2, Name var3) {
      this.method5050(var1);
      var1.method5017(var2, var3);
      this.method5052(var1);
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Lju;I)I",
      garbageValue = "-1662464721"
   )
   final int method5049(Nameable var1) {
      for(int var2 = 0; var2 < this.count; ++var2) {
         if(this.nameables[var2] == var1) {
            return var2;
         }
      }

      return -1;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lju;I)V",
      garbageValue = "-268691451"
   )
   final void method5050(Nameable var1) {
      if(this.field3686.remove(var1.name) == null) {
         throw new IllegalStateException();
      } else {
         if(var1.field3677 != null) {
            this.field3683.remove(var1.field3677);
         }

      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lju;I)V",
      garbageValue = "-2042731039"
   )
   final void method5081(Nameable var1) {
      this.nameables[++this.count - 1] = var1;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lju;S)V",
      garbageValue = "-25820"
   )
   final void method5052(Nameable var1) {
      this.field3686.put(var1.name, var1);
      if(var1.field3677 != null) {
         this.field3683.put(var1.field3677, var1);
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-579154196"
   )
   final void method5057(int var1) {
      --this.count;
      if(var1 < this.count) {
         System.arraycopy(this.nameables, var1 + 1, this.nameables, var1, this.count - var1);
      }

   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(Lbc;IIBB)V",
      garbageValue = "0"
   )
   static final void method5105(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.getSize();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var8 = var0.getSize();
            class168 var9 = class65.method1070(var1, var2);
            CollisionData var10 = Client.collisionMaps[var0.field808];
            int[] var11 = Client.field848;
            int[] var12 = Client.field1079;

            int var13;
            int var14;
            for(var13 = 0; var13 < 128; ++var13) {
               for(var14 = 0; var14 < 128; ++var14) {
                  class167.field2191[var13][var14] = 0;
                  class167.field2188[var13][var14] = 99999999;
               }
            }

            int var15;
            int var16;
            byte var18;
            int var19;
            int var20;
            int var22;
            int var24;
            int var25;
            int var26;
            int var27;
            boolean var33;
            int var35;
            int var36;
            int var38;
            if(var8 == 1) {
               var33 = Resampler.method2278(var4, var5, var9, var10);
            } else {
               byte var17;
               byte var21;
               int[][] var32;
               boolean var34;
               if(var8 == 2) {
                  var15 = var4;
                  var16 = var5;
                  var17 = 64;
                  var18 = 64;
                  var19 = var4 - var17;
                  var20 = var5 - var18;
                  class167.field2191[var17][var18] = 99;
                  class167.field2188[var17][var18] = 0;
                  var21 = 0;
                  var22 = 0;
                  class167.field2186[var21] = var4;
                  var38 = var21 + 1;
                  class167.field2192[var21] = var5;
                  var32 = var10.flags;

                  while(true) {
                     if(var22 == var38) {
                        GameCanvas.field600 = var15;
                        class167.field2190 = var16;
                        var34 = false;
                        break;
                     }

                     var15 = class167.field2186[var22];
                     var16 = class167.field2192[var22];
                     var22 = var22 + 1 & 4095;
                     var35 = var15 - var19;
                     var36 = var16 - var20;
                     var24 = var15 - var10.x;
                     var25 = var16 - var10.y;
                     if(var9.vmethod3287(2, var15, var16, var10)) {
                        GameCanvas.field600 = var15;
                        class167.field2190 = var16;
                        var34 = true;
                        break;
                     }

                     var26 = class167.field2188[var35][var36] + 1;
                     if(var35 > 0 && class167.field2191[var35 - 1][var36] == 0 && (var32[var24 - 1][var25] & 19136782) == 0 && (var32[var24 - 1][var25 + 1] & 19136824) == 0) {
                        class167.field2186[var38] = var15 - 1;
                        class167.field2192[var38] = var16;
                        var38 = var38 + 1 & 4095;
                        class167.field2191[var35 - 1][var36] = 2;
                        class167.field2188[var35 - 1][var36] = var26;
                     }

                     if(var35 < 126 && class167.field2191[var35 + 1][var36] == 0 && (var32[var24 + 2][var25] & 19136899) == 0 && (var32[var24 + 2][var25 + 1] & 19136992) == 0) {
                        class167.field2186[var38] = var15 + 1;
                        class167.field2192[var38] = var16;
                        var38 = var38 + 1 & 4095;
                        class167.field2191[var35 + 1][var36] = 8;
                        class167.field2188[var35 + 1][var36] = var26;
                     }

                     if(var36 > 0 && class167.field2191[var35][var36 - 1] == 0 && (var32[var24][var25 - 1] & 19136782) == 0 && (var32[var24 + 1][var25 - 1] & 19136899) == 0) {
                        class167.field2186[var38] = var15;
                        class167.field2192[var38] = var16 - 1;
                        var38 = var38 + 1 & 4095;
                        class167.field2191[var35][var36 - 1] = 1;
                        class167.field2188[var35][var36 - 1] = var26;
                     }

                     if(var36 < 126 && class167.field2191[var35][var36 + 1] == 0 && (var32[var24][var25 + 2] & 19136824) == 0 && (var32[var24 + 1][var25 + 2] & 19136992) == 0) {
                        class167.field2186[var38] = var15;
                        class167.field2192[var38] = var16 + 1;
                        var38 = var38 + 1 & 4095;
                        class167.field2191[var35][var36 + 1] = 4;
                        class167.field2188[var35][var36 + 1] = var26;
                     }

                     if(var35 > 0 && var36 > 0 && class167.field2191[var35 - 1][var36 - 1] == 0 && (var32[var24 - 1][var25] & 19136830) == 0 && (var32[var24 - 1][var25 - 1] & 19136782) == 0 && (var32[var24][var25 - 1] & 19136911) == 0) {
                        class167.field2186[var38] = var15 - 1;
                        class167.field2192[var38] = var16 - 1;
                        var38 = var38 + 1 & 4095;
                        class167.field2191[var35 - 1][var36 - 1] = 3;
                        class167.field2188[var35 - 1][var36 - 1] = var26;
                     }

                     if(var35 < 126 && var36 > 0 && class167.field2191[var35 + 1][var36 - 1] == 0 && (var32[var24 + 1][var25 - 1] & 19136911) == 0 && (var32[var24 + 2][var25 - 1] & 19136899) == 0 && (var32[var24 + 2][var25] & 19136995) == 0) {
                        class167.field2186[var38] = var15 + 1;
                        class167.field2192[var38] = var16 - 1;
                        var38 = var38 + 1 & 4095;
                        class167.field2191[var35 + 1][var36 - 1] = 9;
                        class167.field2188[var35 + 1][var36 - 1] = var26;
                     }

                     if(var35 > 0 && var36 < 126 && class167.field2191[var35 - 1][var36 + 1] == 0 && (var32[var24 - 1][var25 + 1] & 19136830) == 0 && (var32[var24 - 1][var25 + 2] & 19136824) == 0 && (var32[var24][var25 + 2] & 19137016) == 0) {
                        class167.field2186[var38] = var15 - 1;
                        class167.field2192[var38] = var16 + 1;
                        var38 = var38 + 1 & 4095;
                        class167.field2191[var35 - 1][var36 + 1] = 6;
                        class167.field2188[var35 - 1][var36 + 1] = var26;
                     }

                     if(var35 < 126 && var36 < 126 && class167.field2191[var35 + 1][var36 + 1] == 0 && (var32[var24 + 1][var25 + 2] & 19137016) == 0 && (var32[var24 + 2][var25 + 2] & 19136992) == 0 && (var32[var24 + 2][var25 + 1] & 19136995) == 0) {
                        class167.field2186[var38] = var15 + 1;
                        class167.field2192[var38] = var16 + 1;
                        var38 = var38 + 1 & 4095;
                        class167.field2191[var35 + 1][var36 + 1] = 12;
                        class167.field2188[var35 + 1][var36 + 1] = var26;
                     }
                  }

                  var33 = var34;
               } else {
                  var15 = var4;
                  var16 = var5;
                  var17 = 64;
                  var18 = 64;
                  var19 = var4 - var17;
                  var20 = var5 - var18;
                  class167.field2191[var17][var18] = 99;
                  class167.field2188[var17][var18] = 0;
                  var21 = 0;
                  var22 = 0;
                  class167.field2186[var21] = var4;
                  var38 = var21 + 1;
                  class167.field2192[var21] = var5;
                  var32 = var10.flags;

                  label682:
                  while(true) {
                     label680:
                     while(true) {
                        do {
                           do {
                              do {
                                 label657:
                                 do {
                                    if(var22 == var38) {
                                       GameCanvas.field600 = var15;
                                       class167.field2190 = var16;
                                       var34 = false;
                                       break label682;
                                    }

                                    var15 = class167.field2186[var22];
                                    var16 = class167.field2192[var22];
                                    var22 = var22 + 1 & 4095;
                                    var35 = var15 - var19;
                                    var36 = var16 - var20;
                                    var24 = var15 - var10.x;
                                    var25 = var16 - var10.y;
                                    if(var9.vmethod3287(var8, var15, var16, var10)) {
                                       GameCanvas.field600 = var15;
                                       class167.field2190 = var16;
                                       var34 = true;
                                       break label682;
                                    }

                                    var26 = class167.field2188[var35][var36] + 1;
                                    if(var35 > 0 && class167.field2191[var35 - 1][var36] == 0 && (var32[var24 - 1][var25] & 19136782) == 0 && (var32[var24 - 1][var25 + var8 - 1] & 19136824) == 0) {
                                       var27 = 1;

                                       while(true) {
                                          if(var27 >= var8 - 1) {
                                             class167.field2186[var38] = var15 - 1;
                                             class167.field2192[var38] = var16;
                                             var38 = var38 + 1 & 4095;
                                             class167.field2191[var35 - 1][var36] = 2;
                                             class167.field2188[var35 - 1][var36] = var26;
                                             break;
                                          }

                                          if((var32[var24 - 1][var25 + var27] & 19136830) != 0) {
                                             break;
                                          }

                                          ++var27;
                                       }
                                    }

                                    if(var35 < 128 - var8 && class167.field2191[var35 + 1][var36] == 0 && (var32[var8 + var24][var25] & 19136899) == 0 && (var32[var8 + var24][var8 + var25 - 1] & 19136992) == 0) {
                                       var27 = 1;

                                       while(true) {
                                          if(var27 >= var8 - 1) {
                                             class167.field2186[var38] = var15 + 1;
                                             class167.field2192[var38] = var16;
                                             var38 = var38 + 1 & 4095;
                                             class167.field2191[var35 + 1][var36] = 8;
                                             class167.field2188[var35 + 1][var36] = var26;
                                             break;
                                          }

                                          if((var32[var24 + var8][var27 + var25] & 19136995) != 0) {
                                             break;
                                          }

                                          ++var27;
                                       }
                                    }

                                    if(var36 > 0 && class167.field2191[var35][var36 - 1] == 0 && (var32[var24][var25 - 1] & 19136782) == 0 && (var32[var8 + var24 - 1][var25 - 1] & 19136899) == 0) {
                                       var27 = 1;

                                       while(true) {
                                          if(var27 >= var8 - 1) {
                                             class167.field2186[var38] = var15;
                                             class167.field2192[var38] = var16 - 1;
                                             var38 = var38 + 1 & 4095;
                                             class167.field2191[var35][var36 - 1] = 1;
                                             class167.field2188[var35][var36 - 1] = var26;
                                             break;
                                          }

                                          if((var32[var24 + var27][var25 - 1] & 19136911) != 0) {
                                             break;
                                          }

                                          ++var27;
                                       }
                                    }

                                    if(var36 < 128 - var8 && class167.field2191[var35][var36 + 1] == 0 && (var32[var24][var25 + var8] & 19136824) == 0 && (var32[var8 + var24 - 1][var8 + var25] & 19136992) == 0) {
                                       var27 = 1;

                                       while(true) {
                                          if(var27 >= var8 - 1) {
                                             class167.field2186[var38] = var15;
                                             class167.field2192[var38] = var16 + 1;
                                             var38 = var38 + 1 & 4095;
                                             class167.field2191[var35][var36 + 1] = 4;
                                             class167.field2188[var35][var36 + 1] = var26;
                                             break;
                                          }

                                          if((var32[var24 + var27][var8 + var25] & 19137016) != 0) {
                                             break;
                                          }

                                          ++var27;
                                       }
                                    }

                                    if(var35 > 0 && var36 > 0 && class167.field2191[var35 - 1][var36 - 1] == 0 && (var32[var24 - 1][var25 - 1] & 19136782) == 0) {
                                       var27 = 1;

                                       while(true) {
                                          if(var27 >= var8) {
                                             class167.field2186[var38] = var15 - 1;
                                             class167.field2192[var38] = var16 - 1;
                                             var38 = var38 + 1 & 4095;
                                             class167.field2191[var35 - 1][var36 - 1] = 3;
                                             class167.field2188[var35 - 1][var36 - 1] = var26;
                                             break;
                                          }

                                          if((var32[var24 - 1][var27 + (var25 - 1)] & 19136830) != 0 || (var32[var27 + (var24 - 1)][var25 - 1] & 19136911) != 0) {
                                             break;
                                          }

                                          ++var27;
                                       }
                                    }

                                    if(var35 < 128 - var8 && var36 > 0 && class167.field2191[var35 + 1][var36 - 1] == 0 && (var32[var8 + var24][var25 - 1] & 19136899) == 0) {
                                       var27 = 1;

                                       while(true) {
                                          if(var27 >= var8) {
                                             class167.field2186[var38] = var15 + 1;
                                             class167.field2192[var38] = var16 - 1;
                                             var38 = var38 + 1 & 4095;
                                             class167.field2191[var35 + 1][var36 - 1] = 9;
                                             class167.field2188[var35 + 1][var36 - 1] = var26;
                                             break;
                                          }

                                          if((var32[var8 + var24][var27 + (var25 - 1)] & 19136995) != 0 || (var32[var27 + var24][var25 - 1] & 19136911) != 0) {
                                             break;
                                          }

                                          ++var27;
                                       }
                                    }

                                    if(var35 > 0 && var36 < 128 - var8 && class167.field2191[var35 - 1][var36 + 1] == 0 && (var32[var24 - 1][var25 + var8] & 19136824) == 0) {
                                       for(var27 = 1; var27 < var8; ++var27) {
                                          if((var32[var24 - 1][var25 + var27] & 19136830) != 0 || (var32[var27 + (var24 - 1)][var8 + var25] & 19137016) != 0) {
                                             continue label657;
                                          }
                                       }

                                       class167.field2186[var38] = var15 - 1;
                                       class167.field2192[var38] = var16 + 1;
                                       var38 = var38 + 1 & 4095;
                                       class167.field2191[var35 - 1][var36 + 1] = 6;
                                       class167.field2188[var35 - 1][var36 + 1] = var26;
                                    }
                                 } while(var35 >= 128 - var8);
                              } while(var36 >= 128 - var8);
                           } while(class167.field2191[var35 + 1][var36 + 1] != 0);
                        } while((var32[var8 + var24][var8 + var25] & 19136992) != 0);

                        for(var27 = 1; var27 < var8; ++var27) {
                           if((var32[var24 + var27][var8 + var25] & 19137016) != 0 || (var32[var24 + var8][var25 + var27] & 19136995) != 0) {
                              continue label680;
                           }
                        }

                        class167.field2186[var38] = var15 + 1;
                        class167.field2192[var38] = var16 + 1;
                        var38 = var38 + 1 & 4095;
                        class167.field2191[var35 + 1][var36 + 1] = 12;
                        class167.field2188[var35 + 1][var36 + 1] = var26;
                     }
                  }

                  var33 = var34;
               }
            }

            int var7;
            label738: {
               var14 = var4 - 64;
               var15 = var5 - 64;
               var16 = GameCanvas.field600;
               var35 = class167.field2190;
               if(!var33) {
                  var36 = Integer.MAX_VALUE;
                  var19 = Integer.MAX_VALUE;
                  byte var37 = 10;
                  var38 = var9.field2197;
                  var22 = var9.field2194;
                  int var23 = var9.field2195;
                  var24 = var9.field2193;

                  for(var25 = var38 - var37; var25 <= var38 + var37; ++var25) {
                     for(var26 = var22 - var37; var26 <= var37 + var22; ++var26) {
                        var27 = var25 - var14;
                        int var28 = var26 - var15;
                        if(var27 >= 0 && var28 >= 0 && var27 < 128 && var28 < 128 && class167.field2188[var27][var28] < 100) {
                           int var29 = 0;
                           if(var25 < var38) {
                              var29 = var38 - var25;
                           } else if(var25 > var38 + var23 - 1) {
                              var29 = var25 - (var23 + var38 - 1);
                           }

                           int var30 = 0;
                           if(var26 < var22) {
                              var30 = var22 - var26;
                           } else if(var26 > var24 + var22 - 1) {
                              var30 = var26 - (var24 + var22 - 1);
                           }

                           int var31 = var30 * var30 + var29 * var29;
                           if(var31 < var36 || var36 == var31 && class167.field2188[var27][var28] < var19) {
                              var36 = var31;
                              var19 = class167.field2188[var27][var28];
                              var16 = var25;
                              var35 = var26;
                           }
                        }
                     }
                  }

                  if(var36 == Integer.MAX_VALUE) {
                     var7 = -1;
                     break label738;
                  }
               }

               if(var16 == var4 && var5 == var35) {
                  var7 = 0;
               } else {
                  var18 = 0;
                  class167.field2186[var18] = var16;
                  var36 = var18 + 1;
                  class167.field2192[var18] = var35;

                  for(var19 = var20 = class167.field2191[var16 - var14][var35 - var15]; var4 != var16 || var35 != var5; var19 = class167.field2191[var16 - var14][var35 - var15]) {
                     if(var20 != var19) {
                        var20 = var19;
                        class167.field2186[var36] = var16;
                        class167.field2192[var36++] = var35;
                     }

                     if((var19 & 2) != 0) {
                        ++var16;
                     } else if((var19 & 8) != 0) {
                        --var16;
                     }

                     if((var19 & 1) != 0) {
                        ++var35;
                     } else if((var19 & 4) != 0) {
                        --var35;
                     }
                  }

                  var38 = 0;

                  while(var36-- > 0) {
                     var11[var38] = class167.field2186[var36];
                     var12[var38++] = class167.field2192[var36];
                     if(var38 >= var11.length) {
                        break;
                     }
                  }

                  var7 = var38;
               }
            }

            var13 = var7;
            if(var7 >= 1) {
               for(var14 = 0; var14 < var13 - 1; ++var14) {
                  var0.method1151(Client.field848[var14], Client.field1079[var14], var3);
               }

            }
         }
      }
   }
}
