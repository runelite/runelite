import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("s")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("g")
   public static class182 field3059;
   @ObfuscatedName("j")
   int[] field3061;
   @ObfuscatedName("p")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("m")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("y")
   public static NodeCache field3064 = new NodeCache(100);
   @ObfuscatedName("a")
   public int[] field3065;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -9123019
   )
   @Export("frameStep")
   public int frameStep = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1857709631
   )
   @Export("maxLoops")
   public int maxLoops = 99;
   @ObfuscatedName("k")
   @Export("stretches")
   public boolean stretches = false;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1042379463
   )
   @Export("forcedPriority")
   public int forcedPriority = 5;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 934696915
   )
   @Export("leftHandItem")
   public int leftHandItem = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2025353249
   )
   @Export("rightHandItem")
   public int rightHandItem = -1;
   @ObfuscatedName("x")
   public static class182 field3072;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 791601073
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -705009311
   )
   @Export("priority")
   public int priority = -1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 281966677
   )
   @Export("replyMode")
   public int replyMode = 2;
   @ObfuscatedName("v")
   public static NodeCache field3078 = new NodeCache(64);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-1"
   )
   void method3815(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3829(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-455935443"
   )
   void method3817() {
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
      signature = "(LModel;II)LModel;",
      garbageValue = "1810031842"
   )
   public Model method3818(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = GameObject.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method1697(true);
      } else {
         Model var4 = var1.method1697(!var3.method1990(var2));
         var4.method1652(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LModel;IIB)LModel;",
      garbageValue = "49"
   )
   Model method3819(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = GameObject.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var4) {
         return var1.method1697(true);
      } else {
         Model var5 = var1.method1697(!var4.method1990(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method1719();
         } else if(var3 == 2) {
            var5.method1700();
         } else if(var3 == 3) {
            var5.method1718();
         }

         var5.method1652(var4, var2);
         if(var3 == 1) {
            var5.method1718();
         } else if(var3 == 2) {
            var5.method1700();
         } else if(var3 == 3) {
            var5.method1719();
         }

         return var5;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LModel;IB)LModel;",
      garbageValue = "1"
   )
   Model method3820(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = GameObject.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method1647(true);
      } else {
         Model var4 = var1.method1647(!var3.method1990(var2));
         var4.method1652(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "682913203"
   )
   public Model method3821(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = GameObject.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method1697(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3061 != null && var2 < this.field3061.length) {
            var6 = this.field3061[var2];
            var5 = GameObject.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(null != var5 && var6 != '\uffff') {
            var7 = var1.method1697(!var4.method1990(var3) & !var5.method1990(var6));
            var7.method1652(var4, var3);
            var7.method1652(var5, var6);
            return var7;
         } else {
            var7 = var1.method1697(!var4.method1990(var3));
            var7.method1652(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;IS)V",
      garbageValue = "-30063"
   )
   void method3829(Buffer var1, int var2) {
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
         this.field3061 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3061[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3061[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3065 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3065[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;II)LModel;",
      garbageValue = "-2033849331"
   )
   public Model method3831(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = GameObject.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var5) {
         return var3.method3818(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = GameObject.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(var6 == null) {
            var7 = var1.method1697(!var5.method1990(var2));
            var7.method1652(var5, var2);
            return var7;
         } else {
            var7 = var1.method1697(!var5.method1990(var2) & !var6.method1990(var4));
            var7.method1653(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }
}
