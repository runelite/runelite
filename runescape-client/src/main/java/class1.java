import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class1 {
   @ObfuscatedName("f")
   public static Comparator field8;
   @ObfuscatedName("i")
   public static Comparator field9;
   @ObfuscatedName("a")
   public static Comparator field10;
   @ObfuscatedName("x")
   public static Comparator field11 = new class7();
   @ObfuscatedName("u")
   public final List field12;

   @ObfuscatedName("ee")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1515581369"
   )
   static final void method9(String var0) {
      if(null != var0) {
         String var1 = class139.method2601(var0, Ignore.field209);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
               Ignore var3 = Client.ignores[var2];
               String var4 = var3.name;
               String var5 = class139.method2601(var4, Ignore.field209);
               if(class170.method3216(var0, var1, var4, var5)) {
                  --Client.ignoreCount;

                  for(int var6 = var2; var6 < Client.ignoreCount; ++var6) {
                     Client.ignores[var6] = Client.ignores[var6 + 1];
                  }

                  Client.field460 = Client.field446;
                  Client.field326.method3029(127);
                  Client.field326.method2760(class148.method2740(var0));
                  Client.field326.method2811(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZB)V",
      garbageValue = "-79"
   )
   public void method10(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field12, var1);
      } else {
         Collections.sort(this.field12, Collections.reverseOrder(var1));
      }

   }

   static {
      new class0();
      field9 = new class5();
      field10 = new class6();
      field8 = new class3();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILclass116;Lclass184;B)V",
      garbageValue = "91"
   )
   static void method11(int var0, class116 var1, class184 var2) {
      byte[] var3 = null;
      Deque var4 = class183.field2705;
      synchronized(class183.field2705) {
         for(class180 var5 = (class180)class183.field2705.method2391(); var5 != null; var5 = (class180)class183.field2705.method2393()) {
            if((long)var0 == var5.hash && var5.field2670 == var1 && var5.field2673 == 0) {
               var3 = var5.field2675;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method3361(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2227(var0);
         var2.method3361(var1, var0, var8, true);
      }
   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "1"
   )
   public class1(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.field12 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field12.add(new class2(var1, var5, var3));
      }

   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-9"
   )
   static final void method13() {
      for(int var0 = 0; var0 < Client.field324; ++var0) {
         int var1 = Client.field370[var0];
         NPC var2 = Client.cachedNPCs[var1];
         int var3 = Client.field409.readUnsignedByte();
         int var4;
         if((var3 & 16) != 0) {
            var2.graphic = Client.field409.method2922();
            var4 = Client.field409.method2819();
            var2.field640 = var4 >> 16;
            var2.field648 = (var4 & '\uffff') + Client.gameCycle;
            var2.field634 = 0;
            var2.field638 = 0;
            if(var2.field648 > Client.gameCycle) {
               var2.field634 = -1;
            }

            if(var2.graphic == '\uffff') {
               var2.graphic = -1;
            }
         }

         int var5;
         int var6;
         if((var3 & 4) != 0) {
            var4 = Client.field409.method2922();
            if(var4 == '\uffff') {
               var4 = -1;
            }

            var5 = Client.field409.method2802();
            if(var2.animation == var4 && var4 != -1) {
               var6 = CombatInfo2.getAnimation(var4).replyMode;
               if(var6 == 1) {
                  var2.actionFrame = 0;
                  var2.field633 = 0;
                  var2.actionAnimationDisable = var5;
                  var2.field635 = 0;
               }

               if(var6 == 2) {
                  var2.field635 = 0;
               }
            } else if(var4 == -1 || var2.animation == -1 || CombatInfo2.getAnimation(var4).forcedPriority >= CombatInfo2.getAnimation(var2.animation).forcedPriority) {
               var2.animation = var4;
               var2.actionFrame = 0;
               var2.field633 = 0;
               var2.actionAnimationDisable = var5;
               var2.field635 = 0;
               var2.field658 = var2.field653;
            }
         }

         if((var3 & 64) != 0) {
            var2.composition = Actor.getNpcDefinition(Client.field409.method2779());
            var2.field603 = var2.composition.field3007;
            var2.field616 = var2.composition.field3015;
            var2.field607 = var2.composition.field3000;
            var2.field608 = var2.composition.field3019;
            var2.field639 = var2.composition.field2995;
            var2.field614 = var2.composition.field3001;
            var2.idlePoseAnimation = var2.composition.field2992;
            var2.field605 = var2.composition.field2987;
            var2.field626 = var2.composition.field2997;
         }

         if((var3 & 1) != 0) {
            var2.overhead = Client.field409.method2965();
            var2.field615 = 100;
         }

         int var7;
         if((var3 & 8) != 0) {
            var4 = Client.field409.method2779();
            var5 = Client.field409.readUnsignedShort();
            var6 = var2.x - (var4 - FrameMap.baseX - FrameMap.baseX) * 64;
            var7 = var2.y - 64 * (var5 - XItemContainer.baseY - XItemContainer.baseY);
            if(var6 != 0 || var7 != 0) {
               var2.field627 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if((var3 & 2) != 0) {
            var2.interacting = Client.field409.method2762();
            if(var2.interacting == '\uffff') {
               var2.interacting = -1;
            }
         }

         if((var3 & 32) != 0) {
            var4 = Client.field409.method2803();
            int var8;
            int var9;
            int var10;
            if(var4 > 0) {
               for(var5 = 0; var5 < var4; ++var5) {
                  var7 = -1;
                  var8 = -1;
                  var9 = -1;
                  var6 = Client.field409.method2963();
                  if(var6 == 32767) {
                     var6 = Client.field409.method2963();
                     var8 = Client.field409.method2963();
                     var7 = Client.field409.method2963();
                     var9 = Client.field409.method2963();
                  } else if(var6 != 32766) {
                     var8 = Client.field409.method2963();
                  } else {
                     var6 = -1;
                  }

                  var10 = Client.field409.method2963();
                  var2.method614(var6, var8, var7, var9, Client.gameCycle, var10);
               }
            }

            var5 = Client.field409.readUnsignedByte();
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var7 = Client.field409.method2963();
                  var8 = Client.field409.method2963();
                  if(var8 != 32767) {
                     var9 = Client.field409.method2963();
                     var10 = Client.field409.method2804();
                     int var11 = var8 > 0?Client.field409.method2803():var10;
                     var2.method605(var7, Client.gameCycle, var8, var9, var10, var11);
                  } else {
                     var2.method606(var7);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "1592555284"
   )
   static void method14(Widget var0, int var1, int var2) {
      if(var0.field2230 == 0) {
         var0.relativeX = var0.field2194;
      } else if(var0.field2230 == 1) {
         var0.relativeX = (var1 - var0.width) / 2 + var0.field2194;
      } else if(var0.field2230 == 2) {
         var0.relativeX = var1 - var0.width - var0.field2194;
      } else if(var0.field2230 == 3) {
         var0.relativeX = var1 * var0.field2194 >> 14;
      } else if(var0.field2230 == 4) {
         var0.relativeX = (var0.field2194 * var1 >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var0.field2194 * var1 >> 14);
      }

      if(var0.field2191 == 0) {
         var0.relativeY = var0.field2195;
      } else if(var0.field2191 == 1) {
         var0.relativeY = var0.field2195 + (var2 - var0.height) / 2;
      } else if(var0.field2191 == 2) {
         var0.relativeY = var2 - var0.height - var0.field2195;
      } else if(var0.field2191 == 3) {
         var0.relativeY = var0.field2195 * var2 >> 14;
      } else if(var0.field2191 == 4) {
         var0.relativeY = (var2 - var0.height) / 2 + (var0.field2195 * var2 >> 14);
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.field2195 >> 14);
      }

      if(Client.field414 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.relativeX + var0.width > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.relativeY + var0.height > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Lclass189;",
      garbageValue = "469011368"
   )
   public static class189 method16(int var0) {
      class189 var1 = (class189)class189.field2760.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class189.field2764.method3272(15, var0);
         var1 = new class189();
         if(null != var2) {
            var1.method3437(new Buffer(var2));
         }

         class189.field2760.put(var1, (long)var0);
         return var1;
      }
   }
}
