import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1134632305
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating = -1;
   @ObfuscatedName("p")
   static NodeCache field3054 = new NodeCache(64);
   @ObfuscatedName("j")
   static NodeCache field3055 = new NodeCache(100);
   @ObfuscatedName("n")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1934270951
   )
   @Export("forcedPriority")
   public int forcedPriority = 5;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1028346157
   )
   @Export("maxLoops")
   public int maxLoops = 99;
   @ObfuscatedName("i")
   public int[] field3059;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 430498007
   )
   @Export("rightHandItem")
   public int rightHandItem = -1;
   @ObfuscatedName("m")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("s")
   @Export("stretches")
   public boolean stretches = false;
   @ObfuscatedName("c")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1705485625
   )
   @Export("leftHandItem")
   public int leftHandItem = -1;
   @ObfuscatedName("r")
   int[] field3065;
   @ObfuscatedName("q")
   static class182 field3066;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2131830371
   )
   @Export("frameStep")
   public int frameStep = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1923199887
   )
   @Export("priority")
   public int priority = -1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1944741691
   )
   @Export("replyMode")
   public int replyMode = 2;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1793887542"
   )
   void method3777(Buffer var1, int var2) {
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
         this.field3065 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3065[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3065[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3059 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3059[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LModel;III)LModel;",
      garbageValue = "-1947278878"
   )
   Model method3780(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class161.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var4) {
         return var1.method1614(true);
      } else {
         Model var5 = var1.method1614(!var4.method1962(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method1625();
         } else if(var3 == 2) {
            var5.method1624();
         } else if(var3 == 3) {
            var5.method1623();
         }

         var5.method1660(var4, var2);
         if(var3 == 1) {
            var5.method1623();
         } else if(var3 == 2) {
            var5.method1624();
         } else if(var3 == 3) {
            var5.method1625();
         }

         return var5;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;II)LModel;",
      garbageValue = "877559365"
   )
   public Model method3782(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class161.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var5) {
         return var3.method3793(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class161.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(var6 == null) {
            var7 = var1.method1614(!var5.method1962(var2));
            var7.method1660(var5, var2);
            return var7;
         } else {
            var7 = var1.method1614(!var5.method1962(var2) & !var6.method1962(var4));
            var7.method1621(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-491186643"
   )
   public Model method3783(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class161.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method1614(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(null != this.field3065 && var2 < this.field3065.length) {
            var6 = this.field3065[var2];
            var5 = class161.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(null != var5 && var6 != '\uffff') {
            var7 = var1.method1614(!var4.method1962(var3) & !var5.method1962(var6));
            var7.method1660(var4, var3);
            var7.method1660(var5, var6);
            return var7;
         } else {
            var7 = var1.method1614(!var4.method1962(var3));
            var7.method1660(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1452830118"
   )
   void method3785() {
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "1958658983"
   )
   public Model method3793(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class161.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method1614(true);
      } else {
         Model var4 = var1.method1614(!var3.method1962(var2));
         var4.method1660(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "1650991597"
   )
   Model method3811(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class161.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method1615(true);
      } else {
         Model var4 = var1.method1615(!var3.method1962(var2));
         var4.method1660(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-162021582"
   )
   void method3813(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3777(var1, var2);
      }
   }
}
