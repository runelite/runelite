import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
public class class72 {
   @ObfuscatedName("k")
   FileOnDisk field1177;
   @ObfuscatedName("y")
   byte[] field1178;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 4298764122693738655L
   )
   long field1179 = -1L;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = -6480677496247054117L
   )
   long field1180;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 440110097
   )
   int field1181;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 1743434467059470703L
   )
   long field1182 = -1L;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1359344049
   )
   int field1183 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 2625751523862306431L
   )
   long field1184;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 7145926479412057073L
   )
   long field1185;
   @ObfuscatedName("w")
   byte[] field1186;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 5383716469103131979L
   )
   long field1187;
   @ObfuscatedName("mc")
   @ObfuscatedGetter(
      intValue = 1121315799
   )
   @Export("clanChatCount")
   static int clanChatCount;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Lclass109;",
      garbageValue = "173498480"
   )
   static class109 method1387() {
      try {
         return new class98();
      } catch (Throwable var1) {
         return new class99();
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-15158"
   )
   public void method1388() throws IOException {
      this.method1395();
      this.field1177.method1419();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "794556041"
   )
   public void method1391(byte[] var1) throws IOException {
      this.method1413(var1, 0, var1.length);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-118"
   )
   void method1392() throws IOException {
      this.field1181 = 0;
      if(this.field1187 != this.field1184) {
         this.field1177.method1417(this.field1184);
         this.field1187 = this.field1184;
      }

      int var1;
      for(this.field1179 = this.field1184; this.field1181 < this.field1178.length; this.field1181 += var1) {
         var1 = this.field1177.method1421(this.field1178, this.field1181, this.field1178.length - this.field1181);
         if(var1 == -1) {
            break;
         }

         this.field1187 += (long)var1;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "2049216610"
   )
   public void method1394(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.field1184 + (long)var3 > this.field1180) {
            this.field1180 = (long)var3 + this.field1184;
         }

         if(this.field1182 != -1L && (this.field1184 < this.field1182 || this.field1184 > (long)this.field1183 + this.field1182)) {
            this.method1395();
         }

         if(-1L != this.field1182 && this.field1184 + (long)var3 > this.field1182 + (long)this.field1186.length) {
            int var4 = (int)((long)this.field1186.length - (this.field1184 - this.field1182));
            System.arraycopy(var1, var2, this.field1186, (int)(this.field1184 - this.field1182), var4);
            this.field1184 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1183 = this.field1186.length;
            this.method1395();
         }

         if(var3 <= this.field1186.length) {
            if(var3 > 0) {
               if(-1L == this.field1182) {
                  this.field1182 = this.field1184;
               }

               System.arraycopy(var1, var2, this.field1186, (int)(this.field1184 - this.field1182), var3);
               this.field1184 += (long)var3;
               if(this.field1184 - this.field1182 > (long)this.field1183) {
                  this.field1183 = (int)(this.field1184 - this.field1182);
               }

            }
         } else {
            if(this.field1184 != this.field1187) {
               this.field1177.method1417(this.field1184);
               this.field1187 = this.field1184;
            }

            this.field1177.method1418(var1, var2, var3);
            this.field1187 += (long)var3;
            if(this.field1187 > this.field1185) {
               this.field1185 = this.field1187;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.field1184 >= this.field1179 && this.field1184 < (long)this.field1181 + this.field1179) {
               var9 = this.field1184;
            } else if(this.field1179 >= this.field1184 && this.field1179 < this.field1184 + (long)var3) {
               var9 = this.field1179;
            }

            if(this.field1184 + (long)var3 > this.field1179 && this.field1184 + (long)var3 <= this.field1179 + (long)this.field1181) {
               var6 = this.field1184 + (long)var3;
            } else if((long)this.field1181 + this.field1179 > this.field1184 && (long)this.field1181 + this.field1179 <= (long)var3 + this.field1184) {
               var6 = (long)this.field1181 + this.field1179;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)((long)var2 + var9 - this.field1184), this.field1178, (int)(var9 - this.field1179), var8);
            }

            this.field1184 += (long)var3;
         }
      } catch (IOException var12) {
         this.field1187 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-62"
   )
   void method1395() throws IOException {
      if(-1L != this.field1182) {
         if(this.field1182 != this.field1187) {
            this.field1177.method1417(this.field1182);
            this.field1187 = this.field1182;
         }

         this.field1177.method1418(this.field1186, 0, this.field1183);
         this.field1187 += 1359344049L * (long)(this.field1183 * -399919279);
         if(this.field1187 > this.field1185) {
            this.field1185 = this.field1187;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1182 >= this.field1179 && this.field1182 < this.field1179 + (long)this.field1181) {
            var1 = this.field1182;
         } else if(this.field1179 >= this.field1182 && this.field1179 < this.field1182 + (long)this.field1183) {
            var1 = this.field1179;
         }

         if(this.field1182 + (long)this.field1183 > this.field1179 && this.field1182 + (long)this.field1183 <= this.field1179 + (long)this.field1181) {
            var3 = this.field1182 + (long)this.field1183;
         } else if(this.field1179 + (long)this.field1181 > this.field1182 && this.field1179 + (long)this.field1181 <= this.field1182 + (long)this.field1183) {
            var3 = this.field1179 + (long)this.field1181;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field1186, (int)(var1 - this.field1182), this.field1178, (int)(var1 - this.field1179), var5);
         }

         this.field1182 = -1L;
         this.field1183 = 0;
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(LActor;IB)V",
      garbageValue = "61"
   )
   static final void method1396(Actor var0, int var1) {
      int var8;
      if(var0.field636 > Client.gameCycle) {
         class166.method3199(var0);
      } else if(var0.field637 >= Client.gameCycle) {
         if(var0.field637 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || 1 + var0.field624 > TextureProvider.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
            var8 = var0.field637 - var0.field636;
            int var3 = Client.gameCycle - var0.field636;
            int var4 = var0.field597 * 64 + var0.field632 * 128;
            int var5 = var0.field634 * 128 + var0.field597 * 64;
            int var6 = var0.field597 * 64 + var0.field633 * 128;
            int var7 = var0.field597 * 64 + var0.field605 * 128;
            var0.x = (var4 * (var8 - var3) + var3 * var6) / var8;
            var0.y = (var7 * var3 + (var8 - var3) * var5) / var8;
         }

         var0.field638 = 0;
         var0.field641 = var0.field616;
         var0.angle = var0.field641;
      } else {
         class159.method2908(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field636 = 0;
         var0.field637 = 0;
         var0.x = 128 * var0.pathX[0] + var0.field597 * 64;
         var0.y = 128 * var0.pathY[0] + var0.field597 * 64;
         var0.method638();
      }

      if(VertexNormal.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field636 = 0;
         var0.field637 = 0;
         var0.x = var0.field597 * 64 + var0.pathX[0] * 128;
         var0.y = var0.pathY[0] * 128 + var0.field597 * 64;
         var0.method638();
      }

      class189.method3453(var0);
      var0.field593 = false;
      Sequence var2;
      if(var0.poseAnimation != -1) {
         var2 = TextureProvider.getAnimation(var0.poseAnimation);
         if(var2 != null && null != var2.frameIDs) {
            ++var0.field621;
            if(var0.poseFrame < var2.frameIDs.length && var0.field621 > var2.frameLenghts[var0.poseFrame]) {
               var0.field621 = 1;
               ++var0.poseFrame;
               class9.method119(var2, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var2.frameIDs.length) {
               var0.field621 = 0;
               var0.poseFrame = 0;
               class9.method119(var2, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.field630) {
         if(var0.field647 < 0) {
            var0.field647 = 0;
         }

         var8 = XItemContainer.method187(var0.graphic).field2778;
         if(var8 != -1) {
            Sequence var9 = TextureProvider.getAnimation(var8);
            if(null != var9 && var9.frameIDs != null) {
               ++var0.field629;
               if(var0.field647 < var9.frameIDs.length && var0.field629 > var9.frameLenghts[var0.field647]) {
                  var0.field629 = 1;
                  ++var0.field647;
                  class9.method119(var9, var0.field647, var0.x, var0.y);
               }

               if(var0.field647 >= var9.frameIDs.length && (var0.field647 < 0 || var0.field647 >= var9.frameIDs.length)) {
                  var0.graphic = -1;
               }
            } else {
               var0.graphic = -1;
            }
         } else {
            var0.graphic = -1;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable <= 1) {
         var2 = TextureProvider.getAnimation(var0.animation);
         if(var2.precedenceAnimating == 1 && var0.field645 > 0 && var0.field636 <= Client.gameCycle && var0.field637 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var2 = TextureProvider.getAnimation(var0.animation);
         if(null != var2 && var2.frameIDs != null) {
            ++var0.field624;
            if(var0.actionFrame < var2.frameIDs.length && var0.field624 > var2.frameLenghts[var0.actionFrame]) {
               var0.field624 = 1;
               ++var0.actionFrame;
               class9.method119(var2, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var2.frameIDs.length) {
               var0.actionFrame -= var2.frameStep;
               ++var0.field590;
               if(var0.field590 >= var2.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var2.frameIDs.length) {
                  class9.method119(var2, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field593 = var2.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("y")
   public void method1404(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field1184 = var1;
      }
   }

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class72(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1177 = var1;
      this.field1180 = this.field1185 = var1.method1420();
      this.field1178 = new byte[var2];
      this.field1186 = new byte[var3];
      this.field1184 = 0L;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1767597330"
   )
   public long method1412() {
      return this.field1180;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-574074594"
   )
   public void method1413(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var2 + var3 - var1.length);
         }

         if(-1L != this.field1182 && this.field1184 >= this.field1182 && this.field1184 + (long)var3 <= (long)this.field1183 + this.field1182) {
            System.arraycopy(this.field1186, (int)(this.field1184 - this.field1182), var1, var2, var3);
            this.field1184 += (long)var3;
            return;
         }

         long var4 = this.field1184;
         int var7 = var3;
         int var8;
         if(this.field1184 >= this.field1179 && this.field1184 < this.field1179 + (long)this.field1181) {
            var8 = (int)((long)this.field1181 - (this.field1184 - this.field1179));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field1178, (int)(this.field1184 - this.field1179), var1, var2, var8);
            this.field1184 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field1178.length) {
            this.field1177.method1417(this.field1184);

            for(this.field1187 = this.field1184; var3 > 0; var3 -= var8) {
               var8 = this.field1177.method1421(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1187 += (long)var8;
               this.field1184 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method1392();
            var8 = var3;
            if(var3 > this.field1181) {
               var8 = this.field1181;
            }

            System.arraycopy(this.field1178, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field1184 += (long)var8;
         }

         if(this.field1182 != -1L) {
            if(this.field1182 > this.field1184 && var3 > 0) {
               var8 = (int)(this.field1182 - this.field1184) + var2;
               if(var8 > var2 + var3) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field1184;
               }
            }

            long var13 = -1L;
            long var10 = -1L;
            if(this.field1182 >= var4 && this.field1182 < (long)var7 + var4) {
               var13 = this.field1182;
            } else if(var4 >= this.field1182 && var4 < this.field1182 + (long)this.field1183) {
               var13 = var4;
            }

            if(this.field1182 + (long)this.field1183 > var4 && this.field1182 + (long)this.field1183 <= var4 + (long)var7) {
               var10 = this.field1182 + (long)this.field1183;
            } else if(var4 + (long)var7 > this.field1182 && var4 + (long)var7 <= (long)this.field1183 + this.field1182) {
               var10 = (long)var7 + var4;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.field1186, (int)(var13 - this.field1182), var1, var2 + (int)(var13 - var4), var12);
               if(var10 > this.field1184) {
                  var3 = (int)((long)var3 - (var10 - this.field1184));
                  this.field1184 = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1187 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-1082749873"
   )
   public static String method1414(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class203.field3063[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILclass182;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "1191264377"
   )
   public static void method1415(int var0, class182 var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.method3284(var2);
      int var7 = var1.method3285(var6, var3);
      class22.method228(var0, var1, var6, var7, var4, var5);
   }
}
