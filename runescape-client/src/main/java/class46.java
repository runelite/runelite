import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class46 {
   @ObfuscatedName("g")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = 746441227
   )
   static int field613;
   @ObfuscatedName("no")
   static byte field618;
   @ObfuscatedName("k")
   byte[][][] field609;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -601596153
   )
   int field619;

   class46(int var1) {
      this.field619 = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-49"
   )
   void method674() {
      byte[] var1 = new byte[this.field619 * this.field619];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field619; ++var3) {
         for(var4 = 0; var4 < this.field619; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field609[0][0] = var1;
      var1 = new byte[this.field619 * this.field619];
      var2 = 0;

      for(var3 = this.field619 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field619; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field609[0][1] = var1;
      var1 = new byte[this.field619 * this.field619];
      var2 = 0;

      for(var3 = 0; var3 < this.field619; ++var3) {
         for(var4 = 0; var4 < this.field619; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field609[0][2] = var1;
      var1 = new byte[this.field619 * this.field619];
      var2 = 0;

      for(var3 = this.field619 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field619; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field609[0][3] = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "908664302"
   )
   int method671(int var1, int var2) {
      if(var2 == 9) {
         var1 = var1 + 1 & 3;
      }

      if(var2 == 10) {
         var1 = var1 + 3 & 3;
      }

      if(var2 == 11) {
         var1 = var1 + 3 & 3;
      }

      return var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "765357429"
   )
   void method675() {
      byte[] var1 = new byte[this.field619 * this.field619];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field619 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field619; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field609[1][0] = var1;
      var1 = new byte[this.field619 * this.field619];
      var2 = 0;

      for(var3 = 0; var3 < this.field619; ++var3) {
         for(var4 = 0; var4 < this.field619; ++var4) {
            if(var2 >= 0 && var2 < var1.length) {
               if(var4 >= var3 << 1) {
                  var1[var2] = -1;
               }

               ++var2;
            } else {
               ++var2;
            }
         }
      }

      this.field609[1][1] = var1;
      var1 = new byte[this.field619 * this.field619];
      var2 = 0;

      for(var3 = 0; var3 < this.field619; ++var3) {
         for(var4 = this.field619 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field609[1][2] = var1;
      var1 = new byte[this.field619 * this.field619];
      var2 = 0;

      for(var3 = this.field619 - 1; var3 >= 0; --var3) {
         for(var4 = this.field619 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field609[1][3] = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "0"
   )
   int method672(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "329245276"
   )
   void method676() {
      byte[] var1 = new byte[this.field619 * this.field619];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field619 - 1; var3 >= 0; --var3) {
         for(var4 = this.field619 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field609[2][0] = var1;
      var1 = new byte[this.field619 * this.field619];
      var2 = 0;

      for(var3 = this.field619 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field619; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field609[2][1] = var1;
      var1 = new byte[this.field619 * this.field619];
      var2 = 0;

      for(var3 = 0; var3 < this.field619; ++var3) {
         for(var4 = 0; var4 < this.field619; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field609[2][2] = var1;
      var1 = new byte[this.field619 * this.field619];
      var2 = 0;

      for(var3 = 0; var3 < this.field619; ++var3) {
         for(var4 = this.field619 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field609[2][3] = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-999268727"
   )
   void method677() {
      byte[] var1 = new byte[this.field619 * this.field619];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field619 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field619; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field609[3][0] = var1;
      var1 = new byte[this.field619 * this.field619];
      var2 = 0;

      for(var3 = 0; var3 < this.field619; ++var3) {
         for(var4 = 0; var4 < this.field619; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field609[3][1] = var1;
      var1 = new byte[this.field619 * this.field619];
      var2 = 0;

      for(var3 = 0; var3 < this.field619; ++var3) {
         for(var4 = this.field619 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field609[3][2] = var1;
      var1 = new byte[this.field619 * this.field619];
      var2 = 0;

      for(var3 = this.field619 - 1; var3 >= 0; --var3) {
         for(var4 = this.field619 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field609[3][3] = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-399303885"
   )
   void method689() {
      byte[] var1 = new byte[this.field619 * this.field619];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field619 - 1; var3 >= 0; --var3) {
         for(var4 = this.field619 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field609[4][0] = var1;
      var1 = new byte[this.field619 * this.field619];
      var2 = 0;

      for(var3 = this.field619 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field619; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field609[4][1] = var1;
      var1 = new byte[this.field619 * this.field619];
      var2 = 0;

      for(var3 = 0; var3 < this.field619; ++var3) {
         for(var4 = 0; var4 < this.field619; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field609[4][2] = var1;
      var1 = new byte[this.field619 * this.field619];
      var2 = 0;

      for(var3 = 0; var3 < this.field619; ++var3) {
         for(var4 = this.field619 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field609[4][3] = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "268074243"
   )
   void method716() {
      byte[] var1 = new byte[this.field619 * this.field619];
      boolean var2 = false;
      var1 = new byte[this.field619 * this.field619];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field619; ++var3) {
         for(var4 = 0; var4 < this.field619; ++var4) {
            if(var4 <= this.field619 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field609[5][0] = var1;
      var1 = new byte[this.field619 * this.field619];
      var5 = 0;

      for(var3 = 0; var3 < this.field619; ++var3) {
         for(var4 = 0; var4 < this.field619; ++var4) {
            if(var3 <= this.field619 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field609[5][1] = var1;
      var1 = new byte[this.field619 * this.field619];
      var5 = 0;

      for(var3 = 0; var3 < this.field619; ++var3) {
         for(var4 = 0; var4 < this.field619; ++var4) {
            if(var4 >= this.field619 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field609[5][2] = var1;
      var1 = new byte[this.field619 * this.field619];
      var5 = 0;

      for(var3 = 0; var3 < this.field619; ++var3) {
         for(var4 = 0; var4 < this.field619; ++var4) {
            if(var3 >= this.field619 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field609[5][3] = var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1069445124"
   )
   void method680() {
      byte[] var1 = new byte[this.field619 * this.field619];
      boolean var2 = false;
      var1 = new byte[this.field619 * this.field619];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field619; ++var3) {
         for(var4 = 0; var4 < this.field619; ++var4) {
            if(var4 <= var3 - this.field619 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field609[6][0] = var1;
      var1 = new byte[this.field619 * this.field619];
      var5 = 0;

      for(var3 = this.field619 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field619; ++var4) {
            if(var4 <= var3 - this.field619 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field609[6][1] = var1;
      var1 = new byte[this.field619 * this.field619];
      var5 = 0;

      for(var3 = this.field619 - 1; var3 >= 0; --var3) {
         for(var4 = this.field619 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field619 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field609[6][2] = var1;
      var1 = new byte[this.field619 * this.field619];
      var5 = 0;

      for(var3 = 0; var3 < this.field619; ++var3) {
         for(var4 = this.field619 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field619 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field609[6][3] = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1062291697"
   )
   void method681() {
      byte[] var1 = new byte[this.field619 * this.field619];
      boolean var2 = false;
      var1 = new byte[this.field619 * this.field619];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field619; ++var3) {
         for(var4 = 0; var4 < this.field619; ++var4) {
            if(var4 >= var3 - this.field619 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field609[7][0] = var1;
      var1 = new byte[this.field619 * this.field619];
      var5 = 0;

      for(var3 = this.field619 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field619; ++var4) {
            if(var4 >= var3 - this.field619 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field609[7][1] = var1;
      var1 = new byte[this.field619 * this.field619];
      var5 = 0;

      for(var3 = this.field619 - 1; var3 >= 0; --var3) {
         for(var4 = this.field619 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field619 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field609[7][2] = var1;
      var1 = new byte[this.field619 * this.field619];
      var5 = 0;

      for(var3 = 0; var3 < this.field619; ++var3) {
         for(var4 = this.field619 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field619 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field609[7][3] = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "65536"
   )
   void method706() {
      if(this.field609 == null) {
         this.field609 = new byte[8][4][];
         this.method674();
         this.method675();
         this.method676();
         this.method677();
         this.method689();
         this.method716();
         this.method680();
         this.method681();
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "39"
   )
   void method679(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field619 != 0 && this.field609 != null) {
         var8 = this.method671(var8, var7);
         var7 = this.method672(var7);
         Rasterizer2D.method5093(var1, var2, var5, var6, var3, var4, this.field609[var7 - 1][var8], this.field619);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Lio;",
      garbageValue = "-1"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.items.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class15.item_ref.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.post();
         if(var1.notedTemplate != -1) {
            var1.method4676(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.notedId != -1) {
            var1.method4664(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
         }

         if(var1.field3542 != -1) {
            var1.method4661(getItemDefinition(var1.field3542), getItemDefinition(var1.field3541));
         }

         if(!isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field3538 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.field3526 = 0;
            if(var1.field3494 != null) {
               boolean var3 = false;

               for(Node var4 = var1.field3494.getHead(); var4 != null; var4 = var1.field3494.getTail()) {
                  class251 var5 = class155.method3049((int)var4.hash);
                  if(var5.field3390) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.field3494 = null;
               }
            }
         }

         ItemComposition.items.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1117424474"
   )
   static void method678(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1280[var5] != var0) {
            var2[var4] = World.field1280[var5];
            var3[var4] = World.field1285[var5];
            ++var4;
         }
      }

      World.field1280 = var2;
      World.field1285 = var3;
      class110.method2174(class138.worldList, 0, class138.worldList.length - 1, World.field1280, World.field1285);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "81"
   )
   static void method714(boolean var0) {
      class90.loginMessage1 = "";
      class90.loginMessage2 = "Enter your username/email & password.";
      class90.loginMessage3 = "";
      class90.loginIndex = 2;
      if(var0) {
         class90.password = "";
      }

      TextureProvider.method2493();
      class43.method622();
   }
}
