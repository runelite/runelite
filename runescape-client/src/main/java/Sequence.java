import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -72441721
   )
   @Export("priority")
   public int priority = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1823826407
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating = -1;
   @ObfuscatedName("o")
   public static class182 field3034;
   @ObfuscatedName("q")
   int[] field3035;
   @ObfuscatedName("w")
   public static NodeCache field3036 = new NodeCache(100);
   @ObfuscatedName("j")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("n")
   public int[] field3038;
   @ObfuscatedName("d")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 587231887
   )
   @Export("forcedPriority")
   public int forcedPriority = 5;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1739928753
   )
   @Export("frameStep")
   public int frameStep = -1;
   @ObfuscatedName("s")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("g")
   @Export("stretches")
   public boolean stretches = false;
   @ObfuscatedName("k")
   public static class182 field3045;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1580995391
   )
   @Export("rightHandItem")
   public int rightHandItem = -1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1695973273
   )
   @Export("maxLoops")
   public int maxLoops = 99;
   @ObfuscatedName("y")
   public static class182 field3048;
   @ObfuscatedName("r")
   public static NodeCache field3049 = new NodeCache(64);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1172596885
   )
   @Export("replyMode")
   public int replyMode = 2;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1080187735
   )
   @Export("leftHandItem")
   public int leftHandItem = -1;
   @ObfuscatedName("pl")
   static class230 field3052;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "0"
   )
   void method3755(Buffer var1, int var2) {
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
         this.field3035 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3035[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3035[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3038 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3038[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-124247297"
   )
   void method3756() {
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "1915046304"
   )
   public Model method3757(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = Widget.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method1565(true);
      } else {
         Model var4 = var1.method1565(!var3.method1887(var2));
         var4.method1571(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;II)LModel;",
      garbageValue = "1965673756"
   )
   public Model method3760(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = Widget.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var5) {
         return var3.method3757(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = Widget.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(null == var6) {
            var7 = var1.method1565(!var5.method1887(var2));
            var7.method1571(var5, var2);
            return var7;
         } else {
            var7 = var1.method1565(!var5.method1887(var2) & !var6.method1887(var4));
            var7.method1572(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-2144651576"
   )
   public Model method3767(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = Widget.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(null == var4) {
         return var1.method1565(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(null != this.field3035 && var2 < this.field3035.length) {
            var6 = this.field3035[var2];
            var5 = Widget.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method1565(!var4.method1887(var3) & !var5.method1887(var6));
            var7.method1571(var4, var3);
            var7.method1571(var5, var6);
            return var7;
         } else {
            var7 = var1.method1565(!var4.method1887(var3));
            var7.method1571(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-963673446"
   )
   Model method3769(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = Widget.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method1607(true);
      } else {
         Model var4 = var1.method1607(!var3.method1887(var2));
         var4.method1571(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LModel;IIB)LModel;",
      garbageValue = "113"
   )
   Model method3772(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = Widget.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var4) {
         return var1.method1565(true);
      } else {
         Model var5 = var1.method1565(!var4.method1887(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method1602();
         } else if(var3 == 2) {
            var5.method1575();
         } else if(var3 == 3) {
            var5.method1574();
         }

         var5.method1571(var4, var2);
         if(var3 == 1) {
            var5.method1574();
         } else if(var3 == 2) {
            var5.method1575();
         } else if(var3 == 3) {
            var5.method1602();
         }

         return var5;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-21"
   )
   void method3780(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3755(var1, var2);
      }
   }
}
