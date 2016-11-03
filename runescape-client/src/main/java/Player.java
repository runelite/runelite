import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -91971667
   )
   int field28;
   @ObfuscatedName("q")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 892851909
   )
   int field30 = -1;
   @ObfuscatedName("ib")
   static Widget field31;
   @ObfuscatedName("j")
   @Export("actions")
   String[] actions = new String[3];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 91598637
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 541509705
   )
   int field35;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1614492021
   )
   int field36;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 388630391
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -278907231
   )
   int field38;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1022894459
   )
   int field39;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2087734647
   )
   int field40;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1649994583
   )
   int field41;
   @ObfuscatedName("p")
   @Export("model")
   Model model;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -749736095
   )
   int field43;
   @ObfuscatedName("k")
   @Export("name")
   String name;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 413345163
   )
   int field45;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -460911965
   )
   int field46 = -1;
   @ObfuscatedName("a")
   boolean field47;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2112784497
   )
   @Export("team")
   int team;
   @ObfuscatedName("z")
   boolean field49;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 961042195
   )
   int field50;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -428540821
   )
   int field51;
   @ObfuscatedName("t")
   boolean field52;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1964577363
   )
   int field53;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1646011061
   )
   int field54;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 523359235
   )
   int field55;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-61979618"
   )
   void method10(int var1, int var2) {
      super.field851 = 0;
      super.field863 = 0;
      super.field883 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method18();
      super.x = var3 * 64 + 128 * super.pathX[0];
      super.y = 128 * super.pathY[0] + var3 * 64;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "14"
   )
   final void method11(Buffer var1) {
      var1.offset = 0;
      int var2 = var1.method2571();
      this.field30 = var1.method2572();
      this.field46 = var1.method2572();
      int var3 = -1;
      this.team = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.method2571();
         if(var6 == 0) {
            var4[var5] = 0;
         } else {
            var7 = var1.method2571();
            var4[var5] = var7 + (var6 << 8);
            if(var5 == 0 && var4[0] == '\uffff') {
               var3 = var1.method2691();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = class22.getItemDefinition(var4[var5] - 512).field1214;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.method2571();
         if(var7 < 0 || var7 >= PlayerComposition.field2968[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.method2691();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field831 = var1.method2691();
      if(super.field831 == '\uffff') {
         super.field831 = -1;
      }

      super.field832 = super.field831;
      super.field833 = var1.method2691();
      if(super.field833 == '\uffff') {
         super.field833 = -1;
      }

      super.field834 = var1.method2691();
      if(super.field834 == '\uffff') {
         super.field834 = -1;
      }

      super.field835 = var1.method2691();
      if(super.field835 == '\uffff') {
         super.field835 = -1;
      }

      super.field836 = var1.method2691();
      if(super.field836 == '\uffff') {
         super.field836 = -1;
      }

      super.field872 = var1.method2691();
      if(super.field872 == '\uffff') {
         super.field872 = -1;
      }

      this.name = var1.method2579();
      if(this == class165.localPlayer) {
         class118.field2034 = this.name;
      }

      this.combatLevel = var1.method2571();
      this.field28 = var1.method2691();
      this.field49 = var1.method2571() == 1;
      if(Client.field279 == 0 && Client.field447 >= 2) {
         this.field49 = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3508(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1714992488"
   )
   protected final Model getModel() {
      if(null == this.composition) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?NPC.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.field47 && (super.idlePoseAnimation != super.poseAnimation || var1 == null)?NPC.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method3514(var1, super.actionFrame, var2, super.poseFrame);
         if(null == var3) {
            return null;
         } else {
            var3.method2366();
            super.field857 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field47 && super.graphic != -1 && super.field827 != -1) {
               var4 = class156.method3182(super.graphic).method938(super.field827);
               if(var4 != null) {
                  var4.method2375(0, -super.field866, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field47 && null != this.model) {
               if(Client.gameCycle >= this.field38) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field38) {
                  var4 = this.model;
                  var4.method2375(this.field39 - super.x, this.field54 - this.field36, this.field50 - super.y);
                  if(super.field876 == 512) {
                     var4.method2371();
                     var4.method2371();
                     var4.method2371();
                  } else if(super.field876 == 1024) {
                     var4.method2371();
                     var4.method2371();
                  } else if(super.field876 == 1536) {
                     var4.method2371();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field876 == 512) {
                     var4.method2371();
                  } else if(super.field876 == 1024) {
                     var4.method2371();
                     var4.method2371();
                  } else if(super.field876 == 1536) {
                     var4.method2371();
                     var4.method2371();
                     var4.method2371();
                  }

                  var4.method2375(super.x - this.field39, this.field36 - this.field54, super.y - this.field50);
               }
            }

            var3.field1911 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "25"
   )
   final void method14(int var1, int var2, byte var3) {
      if(super.animation != -1 && NPC.getAnimation(super.animation).field1018 == 1) {
         super.animation = -1;
      }

      super.field845 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               class92.method2153(this, var1, var2, (byte)2);
            }

            this.method16(var1, var2, var3);
         } else {
            this.method10(var1, var2);
         }
      } else {
         this.method10(var1, var2);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "-125"
   )
   final void method16(int var1, int var2, byte var3) {
      if(super.field851 < 9) {
         ++super.field851;
      }

      for(int var4 = super.field851; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field882[var4] = super.field882[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field882[0] = var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "237256028"
   )
   final boolean vmethod774() {
      return null != this.composition;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1185011090"
   )
   int method18() {
      return this.composition != null && this.composition.field2975 != -1?class110.getNpcDefinition(this.composition.field2975).field899:1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-619826336"
   )
   static void method20() {
      for(class24 var0 = (class24)class24.field609.method3864(); null != var0; var0 = (class24)class24.field609.method3851()) {
         if(var0.field615 != null) {
            var0.method598();
         }
      }

   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "-37"
   )
   static final boolean method30(Widget var0) {
      if(null == var0.field2911) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2911.length; ++var1) {
            int var2 = RSCanvas.method2970(var0, var1);
            int var3 = var0.field2912[var1];
            if(var0.field2911[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2911[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2911[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   Player() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field28 = 0;
      this.totalLevel = 0;
      this.field38 = 0;
      this.field47 = false;
      this.team = 0;
      this.field49 = false;
      this.field52 = false;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1354941866"
   )
   static final void method43() {
      Client.field314.method2806();
      int var0 = Client.field314.method2807(8);
      int var1;
      if(var0 < Client.field319) {
         for(var1 = var0; var1 < Client.field319; ++var1) {
            Client.field406[++Client.field405 - 1] = Client.field501[var1];
         }
      }

      if(var0 > Client.field319) {
         throw new RuntimeException("");
      } else {
         Client.field319 = 0;

         for(var1 = 0; var1 < var0; ++var1) {
            int var2 = Client.field501[var1];
            NPC var3 = Client.cachedNPCs[var2];
            int var4 = Client.field314.method2807(1);
            if(var4 == 0) {
               Client.field501[++Client.field319 - 1] = var2;
               var3.field858 = Client.gameCycle;
            } else {
               int var5 = Client.field314.method2807(2);
               if(var5 == 0) {
                  Client.field501[++Client.field319 - 1] = var2;
                  var3.field858 = Client.gameCycle;
                  Client.field479[++Client.field321 - 1] = var2;
               } else {
                  int var6;
                  int var7;
                  if(var5 == 1) {
                     Client.field501[++Client.field319 - 1] = var2;
                     var3.field858 = Client.gameCycle;
                     var6 = Client.field314.method2807(3);
                     var3.method747(var6, (byte)1);
                     var7 = Client.field314.method2807(1);
                     if(var7 == 1) {
                        Client.field479[++Client.field321 - 1] = var2;
                     }
                  } else if(var5 == 2) {
                     Client.field501[++Client.field319 - 1] = var2;
                     var3.field858 = Client.gameCycle;
                     var6 = Client.field314.method2807(3);
                     var3.method747(var6, (byte)2);
                     var7 = Client.field314.method2807(3);
                     var3.method747(var7, (byte)2);
                     int var8 = Client.field314.method2807(1);
                     if(var8 == 1) {
                        Client.field479[++Client.field321 - 1] = var2;
                     }
                  } else if(var5 == 3) {
                     Client.field406[++Client.field405 - 1] = var2;
                  }
               }
            }
         }

      }
   }
}
