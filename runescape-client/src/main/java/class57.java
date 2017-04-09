import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
public class class57 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1532322933
   )
   int field1061 = 0;
   @ObfuscatedName("l")
   int[] field1064;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2030858049
   )
   int field1066 = 32;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -3816671737764107217L
   )
   long field1067 = class45.method867();
   @ObfuscatedName("e")
   class68[] field1068 = new class68[8];
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -232860109
   )
   int field1069;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 673128347
   )
   int field1070;
   @ObfuscatedName("n")
   class68 field1071;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -423770957
   )
   int field1072 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1736616931
   )
   int field1073 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 9537037
   )
   int field1074 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 4593317024867646977L
   )
   long field1075 = 0L;
   @ObfuscatedName("z")
   boolean field1076 = true;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 603178955
   )
   public static int field1077;
   @ObfuscatedName("i")
   public static boolean field1078;
   @ObfuscatedName("am")
   class68[] field1079 = new class68[8];
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 1124231909821474363L
   )
   long field1081 = 0L;
   @ObfuscatedName("ed")
   static SpritePixels[] field1082;
   @ObfuscatedName("bw")
   static IndexData field1083;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 232491255
   )
   int field1084;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass68;I)V",
      garbageValue = "773009708"
   )
   public final synchronized void method1081(class68 var1) {
      this.field1071 = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-123"
   )
   public final synchronized void method1082() {
      if(this.field1064 != null) {
         long var1 = class45.method867();

         try {
            if(this.field1081 != 0L) {
               if(var1 < this.field1081) {
                  return;
               }

               this.vmethod1149(this.field1084);
               this.field1081 = 0L;
               this.field1076 = true;
            }

            int var3 = this.vmethod1155();
            if(this.field1074 - var3 > this.field1072) {
               this.field1072 = this.field1074 - var3;
            }

            int var4 = this.field1069 + this.field1070;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.field1084) {
               this.field1084 += 1024;
               if(this.field1084 > 16384) {
                  this.field1084 = 16384;
               }

               this.vmethod1147();
               this.vmethod1149(this.field1084);
               var3 = 0;
               this.field1076 = true;
               if(var4 + 256 > this.field1084) {
                  var4 = this.field1084 - 256;
                  this.field1070 = var4 - this.field1069;
               }
            }

            while(var3 < var4) {
               this.method1109(this.field1064, 256);
               this.vmethod1151();
               var3 += 256;
            }

            if(var1 > this.field1075) {
               if(!this.field1076) {
                  if(this.field1072 == 0 && this.field1073 == 0) {
                     this.vmethod1147();
                     this.field1081 = 2000L + var1;
                     return;
                  }

                  this.field1070 = Math.min(this.field1073, this.field1072);
                  this.field1073 = this.field1072;
               } else {
                  this.field1076 = false;
               }

               this.field1072 = 0;
               this.field1075 = var1 + 2000L;
            }

            this.field1074 = var3;
         } catch (Exception var6) {
            this.vmethod1147();
            this.field1081 = 2000L + var1;
         }

         try {
            if(var1 > this.field1067 + 500000L) {
               var1 = this.field1067;
            }

            while(var1 > this.field1067 + 5000L) {
               this.method1086(256);
               this.field1067 += (long)(256000 / field1077);
            }
         } catch (Exception var5) {
            this.field1067 = var1;
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1158073755"
   )
   public final void method1083() {
      this.field1076 = true;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1390046956"
   )
   public final synchronized void method1084() {
      this.field1076 = true;

      try {
         this.vmethod1153();
      } catch (Exception var2) {
         this.vmethod1147();
         this.field1081 = class45.method867() + 2000L;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-851178267"
   )
   final void method1086(int var1) {
      this.field1061 -= var1;
      if(this.field1061 < 0) {
         this.field1061 = 0;
      }

      if(this.field1071 != null) {
         this.field1071.vmethod2756(var1);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass68;II)V",
      garbageValue = "1821681718"
   )
   final void method1088(class68 var1, int var2) {
      int var3 = var2 >> 5;
      class68 var4 = this.field1079[var3];
      if(var4 == null) {
         this.field1068[var3] = var1;
      } else {
         var4.field1166 = var1;
      }

      this.field1079[var3] = var1;
      var1.field1165 = var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-2092069393"
   )
   void vmethod1150(Component var1) throws Exception {
   }

   @ObfuscatedName("p")
   void vmethod1151() throws Exception {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-267320797"
   )
   void vmethod1147() {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-606735368"
   )
   void vmethod1153() throws Exception {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1109(int[] var1, int var2) {
      int var3 = var2;
      if(field1078) {
         var3 = var2 << 1;
      }

      class163.method3153(var1, 0, var3);
      this.field1061 -= var2;
      if(this.field1071 != null && this.field1061 <= 0) {
         this.field1061 += field1077 >> 4;
         class45.method866(this.field1071);
         this.method1088(this.field1071, this.field1071.vmethod1397());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class68 var7;
         label106:
         for(var6 = 7; var5 != 0; --var6) {
            int var8;
            int var9;
            if(var6 < 0) {
               var8 = var6 & 3;
               var9 = -(var6 >> 2);
            } else {
               var8 = var6;
               var9 = 0;
            }

            for(int var10 = var5 >>> var8 & 286331153; var10 != 0; var10 >>>= 4) {
               if((var10 & 1) != 0) {
                  var5 &= ~(1 << var8);
                  var7 = null;
                  class68 var11 = this.field1068[var8];

                  label100:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label100;
                        }

                        class71 var12 = var11.field1164;
                        if(var12 != null && var12.field1198 > var9) {
                           var5 |= 1 << var8;
                           var7 = var11;
                           var11 = var11.field1166;
                        } else {
                           var11.field1167 = true;
                           int var13 = var11.vmethod2766();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1198 += var13;
                           }

                           if(var4 >= this.field1066) {
                              break label106;
                           }

                           class68 var14 = var11.vmethod2768();
                           if(var14 != null) {
                              for(int var15 = var11.field1165; var14 != null; var14 = var11.vmethod2753()) {
                                 this.method1088(var14, var15 * var14.vmethod1397() >> 8);
                              }
                           }

                           class68 var18 = var11.field1166;
                           var11.field1166 = null;
                           if(var7 == null) {
                              this.field1068[var8] = var18;
                           } else {
                              var7.field1166 = var18;
                           }

                           if(var18 == null) {
                              this.field1079[var8] = var7;
                           }

                           var11 = var18;
                        }
                     }
                  }
               }

               var8 += 4;
               ++var9;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class68 var16 = this.field1068[var6];
            class68[] var17 = this.field1068;
            this.field1079[var6] = null;

            for(var17[var6] = null; var16 != null; var16 = var7) {
               var7 = var16.field1166;
               var16.field1166 = null;
            }
         }
      }

      if(this.field1061 < 0) {
         this.field1061 = 0;
      }

      if(this.field1071 != null) {
         this.field1071.vmethod2755(var1, 0, var2);
      }

      this.field1067 = class45.method867();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-927210502"
   )
   public final synchronized void method1113() {
      if(Item.field907 != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == Item.field907.field1114[var2]) {
               Item.field907.field1114[var2] = null;
            }

            if(Item.field907.field1114[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            Item.field907.field1113 = true;

            while(Item.field907.field1116) {
               class115.method2300(50L);
            }

            Item.field907 = null;
         }
      }

      this.vmethod1147();
      this.field1064 = null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1532745636"
   )
   static int method1118(int var0, Script var1, boolean var2) {
      if(var0 == 6500) {
         class32.field743[++class30.field713 - 1] = CombatInfoListHolder.loadWorlds()?1:0;
         return 1;
      } else {
         World var3;
         if(var0 == 6501) {
            var3 = class2.method17();
            if(var3 != null) {
               class32.field743[++class30.field713 - 1] = var3.id;
               class32.field743[++class30.field713 - 1] = var3.mask;
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3.activity;
               class32.field743[++class30.field713 - 1] = var3.location;
               class32.field743[++class30.field713 - 1] = var3.playerCount;
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3.address;
            } else {
               class32.field743[++class30.field713 - 1] = -1;
               class32.field743[++class30.field713 - 1] = 0;
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
               class32.field743[++class30.field713 - 1] = 0;
               class32.field743[++class30.field713 - 1] = 0;
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 6502) {
            var3 = TextureProvider.method1482();
            if(var3 != null) {
               class32.field743[++class30.field713 - 1] = var3.id;
               class32.field743[++class30.field713 - 1] = var3.mask;
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3.activity;
               class32.field743[++class30.field713 - 1] = var3.location;
               class32.field743[++class30.field713 - 1] = var3.playerCount;
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3.address;
            } else {
               class32.field743[++class30.field713 - 1] = -1;
               class32.field743[++class30.field713 - 1] = 0;
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
               class32.field743[++class30.field713 - 1] = 0;
               class32.field743[++class30.field713 - 1] = 0;
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else {
            World var4;
            int var5;
            int var6;
            if(var0 == 6506) {
               var6 = class32.field743[--class30.field713];
               var4 = null;

               for(var5 = 0; var5 < World.field708; ++var5) {
                  if(var6 == World.worldList[var5].id) {
                     var4 = World.worldList[var5];
                     break;
                  }
               }

               if(var4 != null) {
                  class32.field743[++class30.field713 - 1] = var4.id;
                  class32.field743[++class30.field713 - 1] = var4.mask;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var4.activity;
                  class32.field743[++class30.field713 - 1] = var4.location;
                  class32.field743[++class30.field713 - 1] = var4.playerCount;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var4.address;
               } else {
                  class32.field743[++class30.field713 - 1] = -1;
                  class32.field743[++class30.field713 - 1] = 0;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                  class32.field743[++class30.field713 - 1] = 0;
                  class32.field743[++class30.field713 - 1] = 0;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 6507) {
               class30.field713 -= 4;
               var6 = class32.field743[class30.field713];
               boolean var7 = class32.field743[class30.field713 + 1] == 1;
               var5 = class32.field743[class30.field713 + 2];
               boolean var8 = class32.field743[class30.field713 + 3] == 1;
               Friend.method164(var6, var7, var5, var8);
               return 1;
            } else if(var0 != 6511) {
               if(var0 == 6512) {
                  Client.field448 = class32.field743[--class30.field713] == 1;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               var6 = class32.field743[--class30.field713];
               if(var6 >= 0 && var6 < World.field708) {
                  var4 = World.worldList[var6];
                  class32.field743[++class30.field713 - 1] = var4.id;
                  class32.field743[++class30.field713 - 1] = var4.mask;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var4.activity;
                  class32.field743[++class30.field713 - 1] = var4.location;
                  class32.field743[++class30.field713 - 1] = var4.playerCount;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var4.address;
               } else {
                  class32.field743[++class30.field713 - 1] = -1;
                  class32.field743[++class30.field713 - 1] = 0;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                  class32.field743[++class30.field713 - 1] = 0;
                  class32.field743[++class30.field713 - 1] = 0;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "202879557"
   )
   int vmethod1155() throws Exception {
      return this.field1084;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "261119249"
   )
   void vmethod1149(int var1) throws Exception {
   }
}
