import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jo")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("t")
   public static NodeCache field3603;
   @ObfuscatedName("o")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("i")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("w")
   public static NodeCache field3606;
   @ObfuscatedName("z")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("j")
   int[] field3608;
   @ObfuscatedName("e")
   static IndexDataBase field3609;
   @ObfuscatedName("f")
   public int[] field3610;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -583383673
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 843883199
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("q")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("m")
   static IndexDataBase field3614;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2081270099
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -929176721
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -267293031
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1508614121
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1105926055
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -120179143
   )
   @Export("replyMode")
   public int replyMode;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "1"
   )
   void method4575(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4576(var1, var2);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "2"
   )
   void method4576(Buffer var1, int var2) {
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
         this.field3608 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3608[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3608[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3610 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3610[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1229003315"
   )
   void method4577() {
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
      signature = "(LModel;IB)LModel;",
      garbageValue = "34"
   )
   public Model method4578(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class51.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2393(true);
      } else {
         Model var4 = var1.method2393(!var3.method2766(var2));
         var4.method2401(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LModel;IB)LModel;",
      garbageValue = "-16"
   )
   Model method4580(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class51.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2394(true);
      } else {
         Model var4 = var1.method2394(!var3.method2766(var2));
         var4.method2401(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "1333503949"
   )
   public Model method4582(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class51.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method2393(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3608 != null && var2 < this.field3608.length) {
            var6 = this.field3608[var2];
            var5 = class51.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method2393(!var4.method2766(var3) & !var5.method2766(var6));
            var7.method2401(var4, var3);
            var7.method2401(var5, var6);
            return var7;
         } else {
            var7 = var1.method2393(!var4.method2766(var3));
            var7.method2401(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;IB)LModel;",
      garbageValue = "-116"
   )
   public Model method4585(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class51.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method4578(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class51.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(var6 == null) {
            var7 = var1.method2393(!var5.method2766(var2));
            var7.method2401(var5, var2);
            return var7;
         } else {
            var7 = var1.method2393(!var5.method2766(var2) & !var6.method2766(var4));
            var7.method2406(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LModel;III)LModel;",
      garbageValue = "-1095793104"
   )
   Model method4586(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class51.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method2393(true);
      } else {
         Model var5 = var1.method2393(!var4.method2766(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2438();
         } else if(var3 == 2) {
            var5.method2405();
         } else if(var3 == 3) {
            var5.method2427();
         }

         var5.method2401(var4, var2);
         if(var3 == 1) {
            var5.method2427();
         } else if(var3 == 2) {
            var5.method2405();
         } else if(var3 == 3) {
            var5.method2438();
         }

         return var5;
      }
   }

   Sequence() {
      this.frameStep = -1;
      this.stretches = false;
      this.forcedPriority = 5;
      this.leftHandItem = -1;
      this.rightHandItem = -1;
      this.maxLoops = 99;
      this.precedenceAnimating = -1;
      this.priority = -1;
      this.replyMode = 2;
   }

   static {
      field3603 = new NodeCache(64);
      field3606 = new NodeCache(100);
   }
}
