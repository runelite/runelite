import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1345564523
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 29239497
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1873211945
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 289027279
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1819094959
   )
   @Export("z1")
   int z1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1481593637
   )
   int field859;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 851756345
   )
   int field860;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -706129167
   )
   int field861;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 395211007
   )
   int field862;
   @ObfuscatedName("p")
   @Export("x")
   double x;
   @ObfuscatedName("q")
   @Export("az")
   double az;
   @ObfuscatedName("z")
   @Export("isMoving")
   boolean isMoving = false;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1376190725
   )
   @Export("start")
   int start;
   @ObfuscatedName("s")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("o")
   @Export("z")
   double z;
   @ObfuscatedName("y")
   double field869;
   @ObfuscatedName("w")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1336598153
   )
   @Export("id")
   int id;
   @ObfuscatedName("u")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1018843599
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("m")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1029879439
   )
   int field875;
   @ObfuscatedName("e")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1877886389
   )
   int field877 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1494066347
   )
   int field878 = 0;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1422660233"
   )
   final void method858(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.x = (double)this.x1 + var5 * (double)this.start / var9;
         this.velocityZ = (double)this.y1 + var7 * (double)this.start / var9;
         this.z = (double)this.z1;
      }

      var5 = (double)(1 + this.field861 - var4);
      this.field869 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.scalar * this.scalar + this.field869 * this.field869);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan((double)this.field862 * 0.02454369D);
      }

      this.az = ((double)var3 - this.z - var5 * this.velocityX) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-531882622"
   )
   final void method859(int var1) {
      this.isMoving = true;
      this.x += this.field869 * (double)var1;
      this.velocityZ += this.scalar * (double)var1;
      this.z += (double)var1 * this.velocityX + this.az * 0.5D * (double)var1 * (double)var1;
      this.velocityX += (double)var1 * this.az;
      this.field860 = (int)(Math.atan2(this.field869, this.scalar) * 325.949D) + 1024 & 2047;
      this.field875 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(null != this.animationSequence) {
         this.field878 += var1;

         while(true) {
            do {
               do {
                  if(this.field878 <= this.animationSequence.frameLenghts[this.field877]) {
                     return;
                  }

                  this.field878 -= this.animationSequence.frameLenghts[this.field877];
                  ++this.field877;
               } while(this.field877 < this.animationSequence.frameIDs.length);

               this.field877 -= this.animationSequence.frameStep;
            } while(this.field877 >= 0 && this.field877 < this.animationSequence.frameIDs.length);

            this.field877 = 0;
         }
      }
   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIII)V",
      garbageValue = "-2133293810"
   )
   static final void method861(Player var0, int var1, int var2, int var3) {
      if(class9.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.field245 == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + class18.method205(var0.combatLevel, class9.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.field245 + ")" + var0.actions[2];
            }

            int var5;
            if(Client.field438 == 1) {
               class164.addMenuEntry("Use", Client.field439 + " " + "->" + " " + class187.method3515(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field549) {
               if((class137.field1908 & 8) == 8) {
                  class164.addMenuEntry(Client.field328, Client.field350 + " " + "->" + " " + class187.method3515(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.playerOptions[var5] != null) {
                     short var6 = 0;
                     if(Client.playerOptions[var5].equalsIgnoreCase("Attack")) {
                        if(Client.field359 == class40.field808) {
                           continue;
                        }

                        if(Client.field359 == class40.field810 || Client.field359 == class40.field807 && var0.combatLevel > class9.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(class9.localPlayer.team != 0 && var0.team != 0) {
                           if(class9.localPlayer.team == var0.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriority[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = var6 + Client.field410[var5];
                     class164.addMenuEntry(Client.playerOptions[var5], class187.method3515(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = class187.method3515(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass103;Ljava/awt/Component;III)Lclass57;",
      garbageValue = "-260797199"
   )
   public static final class57 method862(class103 var0, Component var1, int var2, int var3) {
      if(class202.field3079 == 0) {
         throw new IllegalStateException();
      } else if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class59 var4 = new class59();
            var4.field1027 = new int[(class57.field1032?2:1) * 256];
            var4.field1033 = var3;
            var4.vmethod1176(var1);
            var4.field1046 = 1024 + (var3 & -1024);
            if(var4.field1046 > 16384) {
               var4.field1046 = 16384;
            }

            var4.vmethod1177(var4.field1046);
            if(class57.field1025 > 0 && class57.field1028 == null) {
               class57.field1028 = new class63();
               class57.field1028.field1079 = var0;
               var0.method2031(class57.field1028, class57.field1025);
            }

            if(null != class57.field1028) {
               if(class57.field1028.field1074[var2] != null) {
                  throw new IllegalArgumentException();
               }

               class57.field1028.field1074[var2] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class57();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.z1 = var5;
      this.startTime = var6;
      this.field861 = var7;
      this.field862 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field859 = var11;
      this.isMoving = false;
      int var12 = class160.method3154(this.id).field2797;
      if(var12 != -1) {
         this.animationSequence = XClanMember.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-8"
   )
   protected final Model getModel() {
      Spotanim var1 = class160.method3154(this.id);
      Model var2 = var1.method3539(this.field877);
      if(var2 == null) {
         return null;
      } else {
         var2.method1612(this.field875);
         return var2;
      }
   }
}
