import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 963791495
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating = -1;
   @ObfuscatedName("h")
   public static NodeCache field3058 = new NodeCache(64);
   @ObfuscatedName("l")
   int[] field3059;
   @ObfuscatedName("o")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("f")
   static IndexDataBase field3061;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = -114464503
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("m")
   public int[] field3063;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -201369787
   )
   @Export("frameStep")
   public int frameStep = -1;
   @ObfuscatedName("n")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("s")
   @Export("stretches")
   public boolean stretches = false;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -716311791
   )
   @Export("forcedPriority")
   public int forcedPriority = 5;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1718642225
   )
   @Export("leftHandItem")
   public int leftHandItem = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2130607891
   )
   @Export("rightHandItem")
   public int rightHandItem = -1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -708480551
   )
   @Export("maxLoops")
   public int maxLoops = 99;
   @ObfuscatedName("r")
   public static NodeCache field3071 = new NodeCache(100);
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 334989299
   )
   @Export("priority")
   public int priority = -1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1303204631
   )
   @Export("replyMode")
   public int replyMode = 2;
   @ObfuscatedName("k")
   static String field3074;
   @ObfuscatedName("j")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("i")
   static IndexDataBase field3078;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "41"
   )
   void method3786(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3787(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1750809776"
   )
   void method3787(Buffer var1, int var2) {
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
         this.field3063 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3063[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "985014714"
   )
   void method3788() {
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-1059030500"
   )
   public Model method3789(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = GroundObject.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method1584(true);
      } else {
         Model var4 = var1.method1584(!var3.method1935(var2));
         var4.method1588(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LModel;IB)LModel;",
      garbageValue = "-116"
   )
   Model method3791(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = GroundObject.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method1585(true);
      } else {
         Model var4 = var1.method1585(!var3.method1935(var2));
         var4.method1588(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;II)LModel;",
      garbageValue = "1407152234"
   )
   public Model method3792(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = GroundObject.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method3789(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = GroundObject.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(null == var6) {
            var7 = var1.method1584(!var5.method1935(var2));
            var7.method1588(var5, var2);
            return var7;
         } else {
            var7 = var1.method1584(!var5.method1935(var2) & !var6.method1935(var4));
            var7.method1646(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LModel;III)LModel;",
      garbageValue = "1808004833"
   )
   Model method3794(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = GroundObject.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var4) {
         return var1.method1584(true);
      } else {
         Model var5 = var1.method1584(!var4.method1935(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method1595();
         } else if(var3 == 2) {
            var5.method1594();
         } else if(var3 == 3) {
            var5.method1656();
         }

         var5.method1588(var4, var2);
         if(var3 == 1) {
            var5.method1656();
         } else if(var3 == 2) {
            var5.method1594();
         } else if(var3 == 3) {
            var5.method1595();
         }

         return var5;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LModel;IB)LModel;",
      garbageValue = "18"
   )
   public Model method3805(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = GroundObject.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(null == var4) {
         return var1.method1584(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3059 != null && var2 < this.field3059.length) {
            var6 = this.field3059[var2];
            var5 = GroundObject.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method1584(!var4.method1935(var3) & !var5.method1935(var6));
            var7.method1588(var4, var3);
            var7.method1588(var5, var6);
            return var7;
         } else {
            var7 = var1.method1584(!var4.method1935(var3));
            var7.method1588(var4, var3);
            return var7;
         }
      }
   }
}
