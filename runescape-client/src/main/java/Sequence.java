import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1649270395
   )
   @Export("rightHandItem")
   public int rightHandItem = -1;
   @ObfuscatedName("k")
   public static NodeCache field3050 = new NodeCache(64);
   @ObfuscatedName("a")
   int[] field3051;
   @ObfuscatedName("n")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("q")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("g")
   public static NodeCache field3054 = new NodeCache(100);
   @ObfuscatedName("w")
   public int[] field3055;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -703969825
   )
   @Export("forcedPriority")
   public int forcedPriority = 5;
   @ObfuscatedName("h")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("p")
   @Export("stretches")
   public boolean stretches = false;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1261633901
   )
   @Export("replyMode")
   public int replyMode = 2;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 983079317
   )
   @Export("leftHandItem")
   public int leftHandItem = -1;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      longValue = -2804968206916442455L
   )
   static long field3061;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 635754033
   )
   @Export("maxLoops")
   public int maxLoops = 99;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -480794557
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1308389919
   )
   @Export("priority")
   public int priority = -1;
   @ObfuscatedName("e")
   static class182 field3065;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 80393839
   )
   @Export("frameStep")
   public int frameStep = -1;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1235773408"
   )
   void method3678(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3679(var1, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "0"
   )
   void method3679(Buffer var1, int var2) {
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
         this.field3055 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3055[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-51"
   )
   void method3680() {
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-973007433"
   )
   public Model method3681(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class16.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method1541(true);
      } else {
         Model var4 = var1.method1541(!var3.method1867(var2));
         var4.method1547(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;IB)LModel;",
      garbageValue = "-123"
   )
   public Model method3684(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class16.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method3681(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class16.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(null == var6) {
            var7 = var1.method1541(!var5.method1867(var2));
            var7.method1547(var5, var2);
            return var7;
         } else {
            var7 = var1.method1541(!var5.method1867(var2) & !var6.method1867(var4));
            var7.method1548(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LModel;IB)LModel;",
      garbageValue = "90"
   )
   public Model method3698(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class16.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(null == var4) {
         return var1.method1541(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(null != this.field3051 && var2 < this.field3051.length) {
            var6 = this.field3051[var2];
            var5 = class16.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(null != var5 && var6 != '\uffff') {
            var7 = var1.method1541(!var4.method1867(var3) & !var5.method1867(var6));
            var7.method1547(var4, var3);
            var7.method1547(var5, var6);
            return var7;
         } else {
            var7 = var1.method1541(!var4.method1867(var3));
            var7.method1547(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LModel;III)LModel;",
      garbageValue = "1639062656"
   )
   Model method3709(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class16.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var4) {
         return var1.method1541(true);
      } else {
         Model var5 = var1.method1541(!var4.method1867(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method1552();
         } else if(var3 == 2) {
            var5.method1551();
         } else if(var3 == 3) {
            var5.method1550();
         }

         var5.method1547(var4, var2);
         if(var3 == 1) {
            var5.method1550();
         } else if(var3 == 2) {
            var5.method1551();
         } else if(var3 == 3) {
            var5.method1552();
         }

         return var5;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-2091097280"
   )
   Model method3712(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class16.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method1542(true);
      } else {
         Model var4 = var1.method1542(!var3.method1867(var2));
         var4.method1547(var3, var2);
         return var4;
      }
   }
}
