import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("a")
   public int[] field3058;
   @ObfuscatedName("i")
   static class182 field3059;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2076250995
   )
   @Export("maxLoops")
   public int maxLoops = 99;
   @ObfuscatedName("k")
   static NodeCache field3061 = new NodeCache(100);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1100624243
   )
   @Export("replyMode")
   public int replyMode = 2;
   @ObfuscatedName("n")
   int[] field3063;
   @ObfuscatedName("l")
   static class182 field3065;
   @ObfuscatedName("f")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("x")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -134225357
   )
   @Export("frameStep")
   public int frameStep = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 953514707
   )
   @Export("forcedPriority")
   public int forcedPriority = 5;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 942668837
   )
   @Export("leftHandItem")
   public int leftHandItem = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -280393729
   )
   @Export("rightHandItem")
   public int rightHandItem = -1;
   @ObfuscatedName("h")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1145136583
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating = -1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1221204353
   )
   @Export("priority")
   public int priority = -1;
   @ObfuscatedName("t")
   static NodeCache field3075 = new NodeCache(64);
   @ObfuscatedName("z")
   @Export("stretches")
   public boolean stretches = false;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-15"
   )
   void method3856(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3857(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1769277242"
   )
   void method3857(Buffer var1, int var2) {
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
         this.field3063 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3063[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3063[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3058 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3058[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-2124265485"
   )
   public Model method3858(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class41.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method1610(true);
      } else {
         Model var4 = var1.method1610(!var3.method1954(var2));
         var4.method1614(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1898798349"
   )
   void method3859() {
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LModel;III)LModel;",
      garbageValue = "-1136608821"
   )
   Model method3860(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class41.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var4) {
         return var1.method1610(true);
      } else {
         Model var5 = var1.method1610(!var4.method1954(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method1622();
         } else if(var3 == 2) {
            var5.method1608();
         } else if(var3 == 3) {
            var5.method1655();
         }

         var5.method1614(var4, var2);
         if(var3 == 1) {
            var5.method1655();
         } else if(var3 == 2) {
            var5.method1608();
         } else if(var3 == 3) {
            var5.method1622();
         }

         return var5;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LModel;IB)LModel;",
      garbageValue = "-16"
   )
   Model method3861(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class41.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method1672(true);
      } else {
         Model var4 = var1.method1672(!var3.method1954(var2));
         var4.method1614(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LModel;IB)LModel;",
      garbageValue = "-119"
   )
   public Model method3863(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class41.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method1610(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3063 != null && var2 < this.field3063.length) {
            var6 = this.field3063[var2];
            var5 = class41.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(null != var5 && var6 != '\uffff') {
            var7 = var1.method1610(!var4.method1954(var3) & !var5.method1954(var6));
            var7.method1614(var4, var3);
            var7.method1614(var5, var6);
            return var7;
         } else {
            var7 = var1.method1610(!var4.method1954(var3));
            var7.method1614(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;IB)LModel;",
      garbageValue = "-78"
   )
   public Model method3881(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class41.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var5) {
         return var3.method3858(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class41.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(null == var6) {
            var7 = var1.method1610(!var5.method1954(var2));
            var7.method1614(var5, var2);
            return var7;
         } else {
            var7 = var1.method1610(!var5.method1954(var2) & !var6.method1954(var4));
            var7.method1618(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }
}
