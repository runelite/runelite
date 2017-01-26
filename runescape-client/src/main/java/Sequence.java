import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("x")
   public static class182 field3044;
   @ObfuscatedName("g")
   public static class182 field3045;
   @ObfuscatedName("p")
   public static class182 field3046;
   @ObfuscatedName("q")
   static NodeCache field3047 = new NodeCache(64);
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 958842683
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating = -1;
   @ObfuscatedName("k")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("d")
   static NodeCache field3050 = new NodeCache(100);
   @ObfuscatedName("j")
   int[] field3051;
   @ObfuscatedName("o")
   public int[] field3052;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2087618233
   )
   @Export("frameStep")
   public int frameStep = -1;
   @ObfuscatedName("c")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 773541073
   )
   @Export("maxLoops")
   public int maxLoops = 99;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1350861519
   )
   @Export("forcedPriority")
   public int forcedPriority = 5;
   @ObfuscatedName("m")
   @Export("stretches")
   public boolean stretches = false;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1764642067
   )
   @Export("rightHandItem")
   public int rightHandItem = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1560030319
   )
   @Export("leftHandItem")
   public int leftHandItem = -1;
   @ObfuscatedName("s")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2089581939
   )
   @Export("priority")
   public int priority = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -3000481
   )
   @Export("replyMode")
   public int replyMode = 2;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "4"
   )
   void method3747(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3748(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "38"
   )
   void method3748(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedShort();
         this.frameLenghts = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameLenghts[var4] = var1.readUnsignedShort();
         }

         this.frameIDs = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameIDs[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameIDs[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 2) {
         this.frameStep = var1.readUnsignedShort();
      } else if(var2 == 3) {
         var3 = var1.readUnsignedByte();
         this.interleaveLeave = new int[var3 + 1];

         for(var4 = 0; var4 < var3; ++var4) {
            this.interleaveLeave[var4] = var1.readUnsignedByte();
         }

         this.interleaveLeave[var3] = 9999999;
      } else if(var2 == 4) {
         this.stretches = true;
      } else if(var2 == 5) {
         this.forcedPriority = var1.readUnsignedByte();
      } else if(var2 == 6) {
         this.leftHandItem = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.rightHandItem = var1.readUnsignedShort();
      } else if(var2 == 8) {
         this.maxLoops = var1.readUnsignedByte();
      } else if(var2 == 9) {
         this.precedenceAnimating = var1.readUnsignedByte();
      } else if(var2 == 10) {
         this.priority = var1.readUnsignedByte();
      } else if(var2 == 11) {
         this.replyMode = var1.readUnsignedByte();
      } else if(var2 == 12) {
         var3 = var1.readUnsignedByte();
         this.field3051 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3051[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3051[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3052 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3052[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2030403369"
   )
   void method3749() {
      if(this.precedenceAnimating == -1) {
         if(this.interleaveLeave != null) {
            this.precedenceAnimating = 2;
         } else {
            this.precedenceAnimating = 0;
         }
      }

      if(this.priority == -1) {
         if(this.interleaveLeave != null) {
            this.priority = 2;
         } else {
            this.priority = 0;
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LModel;IIB)LModel;",
      garbageValue = "106"
   )
   Model method3751(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class180.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var4) {
         return var1.method1555(true);
      } else {
         Model var5 = var1.method1555(!var4.method1897(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method1588();
         } else if(var3 == 2) {
            var5.method1565();
         } else if(var3 == 3) {
            var5.method1568();
         }

         var5.method1566(var4, var2);
         if(var3 == 1) {
            var5.method1568();
         } else if(var3 == 2) {
            var5.method1565();
         } else if(var3 == 3) {
            var5.method1588();
         }

         return var5;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "944331403"
   )
   Model method3752(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class180.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method1556(true);
      } else {
         Model var4 = var1.method1556(!var3.method1897(var2));
         var4.method1566(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;IB)LModel;",
      garbageValue = "-66"
   )
   public Model method3753(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class180.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method3775(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class180.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(null == var6) {
            var7 = var1.method1555(!var5.method1897(var2));
            var7.method1566(var5, var2);
            return var7;
         } else {
            var7 = var1.method1555(!var5.method1897(var2) & !var6.method1897(var4));
            var7.method1562(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LModel;IB)LModel;",
      garbageValue = "114"
   )
   public Model method3754(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class180.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method1555(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3051 != null && var2 < this.field3051.length) {
            var6 = this.field3051[var2];
            var5 = class180.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(null != var5 && var6 != '\uffff') {
            var7 = var1.method1555(!var4.method1897(var3) & !var5.method1897(var6));
            var7.method1566(var4, var3);
            var7.method1566(var5, var6);
            return var7;
         } else {
            var7 = var1.method1555(!var4.method1897(var3));
            var7.method1566(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-36"
   )
   static final void method3768(String var0) {
      if(var0 != null) {
         if((Client.friendCount < 200 || Client.field304 == 1) && Client.friendCount < 400) {
            String var1 = FrameMap.method1697(var0, FaceNormal.field1561);
            if(null != var1) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < Client.friendCount; ++var2) {
                  Friend var3 = Client.friends[var2];
                  var4 = FrameMap.method1697(var3.name, FaceNormal.field1561);
                  if(var4 != null && var4.equals(var1)) {
                     class103.sendGameMessage(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(null != var3.previousName) {
                     var5 = FrameMap.method1697(var3.previousName, FaceNormal.field1561);
                     if(var5 != null && var5.equals(var1)) {
                        class103.sendGameMessage(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < Client.ignoreCount; ++var2) {
                  Ignore var6 = Client.ignores[var2];
                  var4 = FrameMap.method1697(var6.name, FaceNormal.field1561);
                  if(var4 != null && var4.equals(var1)) {
                     class103.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(null != var6.previousName) {
                     var5 = FrameMap.method1697(var6.previousName, FaceNormal.field1561);
                     if(var5 != null && var5.equals(var1)) {
                        class103.sendGameMessage(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(FrameMap.method1697(class16.localPlayer.name, FaceNormal.field1561).equals(var1)) {
                  class103.sendGameMessage(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  Client.field394.method3037(127);
                  Client.field394.method2799(class37.method737(var0));
                  Client.field394.method2805(var0);
               }
            }
         } else {
            class103.sendGameMessage(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LModel;IB)LModel;",
      garbageValue = "15"
   )
   public Model method3775(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class180.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method1555(true);
      } else {
         Model var4 = var1.method1555(!var3.method1897(var2));
         var4.method1566(var3, var2);
         return var4;
      }
   }
}
