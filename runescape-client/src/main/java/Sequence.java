import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1473364659
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating = -1;
   @ObfuscatedName("c")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("g")
   static NodeCache field3048 = new NodeCache(64);
   @ObfuscatedName("h")
   static NodeCache field3049 = new NodeCache(100);
   @ObfuscatedName("v")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("o")
   static class182 field3051;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1880278731
   )
   @Export("maxLoops")
   public int maxLoops = 99;
   @ObfuscatedName("u")
   public int[] field3053;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1906350301
   )
   @Export("frameStep")
   public int frameStep = -1;
   @ObfuscatedName("z")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 286465195
   )
   @Export("forcedPriority")
   public int forcedPriority = 5;
   @ObfuscatedName("m")
   static class182 field3057;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2136659725
   )
   @Export("leftHandItem")
   public int leftHandItem = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 780569889
   )
   @Export("replyMode")
   public int replyMode = 2;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1753794897
   )
   @Export("rightHandItem")
   public int rightHandItem = -1;
   @ObfuscatedName("b")
   static class182 field3061;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 843630917
   )
   @Export("priority")
   public int priority = -1;
   @ObfuscatedName("l")
   int[] field3063;
   @ObfuscatedName("y")
   @Export("stretches")
   public boolean stretches = false;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-486640523"
   )
   void method3663(Buffer var1, int var2) {
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
         this.field3063 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3063[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3063[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3053 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3053[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-1979404878"
   )
   public Model method3665(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class44.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method1534(true);
      } else {
         Model var4 = var1.method1534(!var3.method1847(var2));
         var4.method1526(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LModel;IIS)LModel;",
      garbageValue = "29566"
   )
   Model method3666(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class44.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method1534(true);
      } else {
         Model var5 = var1.method1534(!var4.method1847(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method1531();
         } else if(var3 == 2) {
            var5.method1533();
         } else if(var3 == 3) {
            var5.method1532();
         }

         var5.method1526(var4, var2);
         if(var3 == 1) {
            var5.method1532();
         } else if(var3 == 2) {
            var5.method1533();
         } else if(var3 == 3) {
            var5.method1531();
         }

         return var5;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-455426123"
   )
   Model method3667(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class44.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method1524(true);
      } else {
         Model var4 = var1.method1524(!var3.method1847(var2));
         var4.method1526(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-157295399"
   )
   void method3668() {
      if(this.precedenceAnimating == -1) {
         if(this.interleaveLeave != null) {
            this.precedenceAnimating = 2;
         } else {
            this.precedenceAnimating = 0;
         }
      }

      if(this.priority == -1) {
         if(null != this.interleaveLeave) {
            this.priority = 2;
         } else {
            this.priority = 0;
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LModel;IB)LModel;",
      garbageValue = "-49"
   )
   public Model method3674(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class44.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(null == var4) {
         return var1.method1534(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(null != this.field3063 && var2 < this.field3063.length) {
            var6 = this.field3063[var2];
            var5 = class44.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(null != var5 && var6 != '\uffff') {
            var7 = var1.method1534(!var4.method1847(var3) & !var5.method1847(var6));
            var7.method1526(var4, var3);
            var7.method1526(var5, var6);
            return var7;
         } else {
            var7 = var1.method1534(!var4.method1847(var3));
            var7.method1526(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;II)LModel;",
      garbageValue = "1545167404"
   )
   public Model method3676(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class44.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var5) {
         return var3.method3665(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class44.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(var6 == null) {
            var7 = var1.method1534(!var5.method1847(var2));
            var7.method1526(var5, var2);
            return var7;
         } else {
            var7 = var1.method1534(!var5.method1847(var2) & !var6.method1847(var4));
            var7.method1530(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1096974759"
   )
   static final int method3677(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "80"
   )
   static char method3697(char var0) {
      return var0 != 181 && var0 != 402?Character.toTitleCase(var0):var0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "282048522"
   )
   void method3698(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3663(var1, var2);
      }
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1106214055"
   )
   static final void method3699(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = ChatLineBuffer.method896(var0, var1, class63.plane) - var2;
         var0 -= class110.cameraX;
         var3 -= class189.cameraZ;
         var1 -= class16.cameraY;
         int var4 = class84.field1435[WidgetNode.cameraPitch];
         int var5 = class84.field1446[WidgetNode.cameraPitch];
         int var6 = class84.field1435[class60.cameraYaw];
         int var7 = class84.field1446[class60.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var1 * var7 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var1 * var4 >> 16;
         var1 = var4 * var3 + var1 * var5 >> 16;
         if(var1 >= 50) {
            Client.field392 = var0 * Client.scale / var1 + Client.camera2 / 2;
            Client.field393 = Client.scale * var8 / var1 + Client.camera3 / 2;
         } else {
            Client.field392 = -1;
            Client.field393 = -1;
         }

      } else {
         Client.field392 = -1;
         Client.field393 = -1;
      }
   }
}
