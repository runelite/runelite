import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("m")
   public static class182 field3044;
   @ObfuscatedName("h")
   public static NodeCache field3045 = new NodeCache(64);
   @ObfuscatedName("w")
   public static NodeCache field3046 = new NodeCache(100);
   @ObfuscatedName("r")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("c")
   int[] field3048;
   @ObfuscatedName("n")
   public static class182 field3049;
   @ObfuscatedName("p")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 753518011
   )
   @Export("rightHandItem")
   public int rightHandItem = -1;
   @ObfuscatedName("q")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("l")
   @Export("stretches")
   public boolean stretches = false;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1756092837
   )
   @Export("forcedPriority")
   public int forcedPriority = 5;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1685535099
   )
   @Export("maxLoops")
   public int maxLoops = 99;
   @ObfuscatedName("g")
   public int[] field3056;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -520840169
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating = -1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1719805293
   )
   @Export("leftHandItem")
   public int leftHandItem = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1211161795
   )
   @Export("replyMode")
   public int replyMode = 2;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1987217989
   )
   @Export("frameStep")
   public int frameStep = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1878890717
   )
   @Export("priority")
   public int priority = -1;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-506771913"
   )
   void method3798(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3799(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "0"
   )
   void method3799(Buffer var1, int var2) {
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
         this.interleaveLeave = new int[1 + var3];

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
         this.field3048 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3048[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3048[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3056 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3056[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-552280571"
   )
   void method3800() {
      if(this.precedenceAnimating == -1) {
         if(null != this.interleaveLeave) {
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "829388133"
   )
   public Model method3801(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class182.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method1582(true);
      } else {
         Model var4 = var1.method1582(!var3.method1926(var2));
         var4.method1653(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LModel;III)LModel;",
      garbageValue = "102761659"
   )
   Model method3802(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class182.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var4) {
         return var1.method1582(true);
      } else {
         Model var5 = var1.method1582(!var4.method1926(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method1592();
         } else if(var3 == 2) {
            var5.method1589();
         } else if(var3 == 3) {
            var5.method1590();
         }

         var5.method1653(var4, var2);
         if(var3 == 1) {
            var5.method1590();
         } else if(var3 == 2) {
            var5.method1589();
         } else if(var3 == 3) {
            var5.method1592();
         }

         return var5;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;IS)LModel;",
      garbageValue = "-153"
   )
   public Model method3807(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class182.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var5) {
         return var3.method3801(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class182.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(null == var6) {
            var7 = var1.method1582(!var5.method1926(var2));
            var7.method1653(var5, var2);
            return var7;
         } else {
            var7 = var1.method1582(!var5.method1926(var2) & !var6.method1926(var4));
            var7.method1629(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "1068211930"
   )
   Model method3811(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class182.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method1583(true);
      } else {
         Model var4 = var1.method1583(!var3.method1926(var2));
         var4.method1653(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "1546286870"
   )
   public Model method3823(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class182.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(null == var4) {
         return var1.method1582(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(null != this.field3048 && var2 < this.field3048.length) {
            var6 = this.field3048[var2];
            var5 = class182.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method1582(!var4.method1926(var3) & !var5.method1926(var6));
            var7.method1653(var4, var3);
            var7.method1653(var5, var6);
            return var7;
         } else {
            var7 = var1.method1582(!var4.method1926(var3));
            var7.method1653(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)LModIcon;",
      garbageValue = "15"
   )
   public static ModIcon method3829() {
      ModIcon var0 = new ModIcon();
      var0.width = class225.field3211;
      var0.originalHeight = class225.field3216;
      var0.offsetX = class225.field3213[0];
      var0.offsetY = class225.field3214[0];
      var0.originalWidth = class225.field3215[0];
      var0.height = class225.field3219[0];
      var0.palette = class225.field3210;
      var0.pixels = class225.field3218[0];
      class189.method3507();
      return var0;
   }
}
