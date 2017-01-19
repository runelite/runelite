import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("k")
   int[] field3056;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1001099877
   )
   @Export("leftHandItem")
   public int leftHandItem = -1;
   @ObfuscatedName("f")
   static class182 field3058;
   @ObfuscatedName("h")
   static NodeCache field3059 = new NodeCache(64);
   @ObfuscatedName("a")
   static NodeCache field3060 = new NodeCache(100);
   @ObfuscatedName("s")
   static class182 field3061;
   @ObfuscatedName("u")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("b")
   public int[] field3064;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 180913907
   )
   @Export("frameStep")
   public int frameStep = -1;
   @ObfuscatedName("c")
   static class182 field3066;
   @ObfuscatedName("n")
   @Export("stretches")
   public boolean stretches = false;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2116635889
   )
   @Export("priority")
   public int priority = -1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1053074863
   )
   @Export("replyMode")
   public int replyMode = 2;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1935482293
   )
   @Export("rightHandItem")
   public int rightHandItem = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -805263077
   )
   @Export("maxLoops")
   public int maxLoops = 99;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 149139611
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating = -1;
   @ObfuscatedName("r")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -793207265
   )
   @Export("forcedPriority")
   public int forcedPriority = 5;
   @ObfuscatedName("g")
   @Export("frameIDs")
   public int[] frameIDs;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-753506194"
   )
   void method3608(Buffer var1, int var2) {
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
         this.field3056 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3056[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3056[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3064 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3064[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;S)V",
      garbageValue = "6405"
   )
   void method3609(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3608(var1, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-62012552"
   )
   void method3610() {
      if(this.precedenceAnimating == -1) {
         if(null != this.interleaveLeave) {
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LModel;IB)LModel;",
      garbageValue = "-97"
   )
   public Model method3611(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class150.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method1519(true);
      } else {
         Model var4 = var1.method1519(!var3.method1839(var2));
         var4.method1528(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)[Lclass214;",
      garbageValue = "1114551388"
   )
   public static class214[] method3612() {
      return new class214[]{class214.field3158, class214.field3153, class214.field3155, class214.field3157, class214.field3150, class214.field3148, class214.field3154, class214.field3160, class214.field3156, class214.field3151, class214.field3147, class214.field3146, class214.field3149, class214.field3161, class214.field3159};
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "1630114747"
   )
   Model method3613(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class150.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method1520(true);
      } else {
         Model var4 = var1.method1520(!var3.method1839(var2));
         var4.method1528(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-1414599007"
   )
   public Model method3615(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class150.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(null == var4) {
         return var1.method1519(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(null != this.field3056 && var2 < this.field3056.length) {
            var6 = this.field3056[var2];
            var5 = class150.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method1519(!var4.method1839(var3) & !var5.method1839(var6));
            var7.method1528(var4, var3);
            var7.method1528(var5, var6);
            return var7;
         } else {
            var7 = var1.method1519(!var4.method1839(var3));
            var7.method1528(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LModel;III)LModel;",
      garbageValue = "-84242222"
   )
   Model method3632(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class150.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method1519(true);
      } else {
         Model var5 = var1.method1519(!var4.method1839(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method1530();
         } else if(var3 == 2) {
            var5.method1543();
         } else if(var3 == 3) {
            var5.method1589();
         }

         var5.method1528(var4, var2);
         if(var3 == 1) {
            var5.method1589();
         } else if(var3 == 2) {
            var5.method1543();
         } else if(var3 == 3) {
            var5.method1530();
         }

         return var5;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;II)LModel;",
      garbageValue = "871322523"
   )
   public Model method3638(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class150.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method3611(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class150.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(null == var6) {
            var7 = var1.method1519(!var5.method1839(var2));
            var7.method1528(var5, var2);
            return var7;
         } else {
            var7 = var1.method1519(!var5.method1839(var2) & !var6.method1839(var4));
            var7.method1526(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }
}
