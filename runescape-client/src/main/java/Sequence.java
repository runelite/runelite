import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("c")
   static class182 field3053;
   @ObfuscatedName("j")
   static class182 field3054;
   @ObfuscatedName("q")
   @Export("stretches")
   public boolean stretches = false;
   @ObfuscatedName("e")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("w")
   static NodeCache field3057 = new NodeCache(100);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 990803745
   )
   @Export("maxLoops")
   public int maxLoops = 99;
   @ObfuscatedName("u")
   int[] field3059;
   @ObfuscatedName("k")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("g")
   public int[] field3061;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 266152097
   )
   @Export("frameStep")
   public int frameStep = -1;
   @ObfuscatedName("h")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("x")
   static class182 field3064;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -848797939
   )
   @Export("forcedPriority")
   public int forcedPriority = 5;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1543807751
   )
   @Export("leftHandItem")
   public int leftHandItem = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1423180237
   )
   @Export("rightHandItem")
   public int rightHandItem = -1;
   @ObfuscatedName("d")
   static NodeCache field3068 = new NodeCache(64);
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -535919237
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1392019563
   )
   @Export("priority")
   public int priority = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1167907609
   )
   @Export("replyMode")
   public int replyMode = 2;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1744676375"
   )
   void method3761(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3770(var1, var2);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "1827162190"
   )
   public Model method3763(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = XItemContainer.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method1614(true);
      } else {
         Model var4 = var1.method1614(!var3.method1956(var2));
         var4.method1631(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "479213295"
   )
   Model method3765(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = XItemContainer.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method1615(true);
      } else {
         Model var4 = var1.method1615(!var3.method1956(var2));
         var4.method1631(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LModel;III)LModel;",
      garbageValue = "1593788166"
   )
   Model method3767(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = XItemContainer.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method1614(true);
      } else {
         Model var5 = var1.method1614(!var4.method1956(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method1635();
         } else if(var3 == 2) {
            var5.method1624();
         } else if(var3 == 3) {
            var5.method1647();
         }

         var5.method1631(var4, var2);
         if(var3 == 1) {
            var5.method1647();
         } else if(var3 == 2) {
            var5.method1624();
         } else if(var3 == 3) {
            var5.method1635();
         }

         return var5;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "31"
   )
   void method3770(Buffer var1, int var2) {
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
         this.field3059 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3059[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3059[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3061 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3061[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-19"
   )
   void method3771() {
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;IB)LModel;",
      garbageValue = "68"
   )
   public Model method3777(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = XItemContainer.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var5) {
         return var3.method3763(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = XItemContainer.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(null == var6) {
            var7 = var1.method1614(!var5.method1956(var2));
            var7.method1631(var5, var2);
            return var7;
         } else {
            var7 = var1.method1614(!var5.method1956(var2) & !var6.method1956(var4));
            var7.method1621(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "669413025"
   )
   public Model method3790(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = XItemContainer.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method1614(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3059 != null && var2 < this.field3059.length) {
            var6 = this.field3059[var2];
            var5 = XItemContainer.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method1614(!var4.method1956(var3) & !var5.method1956(var6));
            var7.method1631(var4, var3);
            var7.method1631(var5, var6);
            return var7;
         } else {
            var7 = var1.method1614(!var4.method1956(var3));
            var7.method1631(var4, var3);
            return var7;
         }
      }
   }
}
