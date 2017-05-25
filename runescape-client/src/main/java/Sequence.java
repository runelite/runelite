import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("p")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("q")
   static NodeCache field3596;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1970134701
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("t")
   int[] field3598;
   @ObfuscatedName("g")
   static NodeCache field3599;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 84478377
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("i")
   static IndexDataBase field3601;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -121637141
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("l")
   public int[] field3603;
   @ObfuscatedName("r")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = 751072291
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("v")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2107231533
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 899416987
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1060839547
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1429815925
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1584096793
   )
   @Export("replyMode")
   public int replyMode;
   @ObfuscatedName("k")
   @Export("interleaveLeave")
   int[] interleaveLeave;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-2040756071"
   )
   void method4752(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4759(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LModel;IB)LModel;",
      garbageValue = "82"
   )
   public Model method4755(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class50.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2535(true);
      } else {
         Model var4 = var1.method2535(!var3.method2914(var2));
         var4.method2543(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LModel;IIB)LModel;",
      garbageValue = "14"
   )
   Model method4756(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class50.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method2535(true);
      } else {
         Model var5 = var1.method2535(!var4.method2914(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2585();
         } else if(var3 == 2) {
            var5.method2547();
         } else if(var3 == 3) {
            var5.method2546();
         }

         var5.method2543(var4, var2);
         if(var3 == 1) {
            var5.method2546();
         } else if(var3 == 2) {
            var5.method2547();
         } else if(var3 == 3) {
            var5.method2585();
         }

         return var5;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LModel;IB)LModel;",
      garbageValue = "112"
   )
   Model method4757(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class50.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2558(true);
      } else {
         Model var4 = var1.method2558(!var3.method2914(var2));
         var4.method2543(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;II)LModel;",
      garbageValue = "-863180911"
   )
   public Model method4758(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class50.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method4755(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class50.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(var6 == null) {
            var7 = var1.method2535(!var5.method2914(var2));
            var7.method2543(var5, var2);
            return var7;
         } else {
            var7 = var1.method2535(!var5.method2914(var2) & !var6.method2914(var4));
            var7.method2544(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-536584818"
   )
   void method4759(Buffer var1, int var2) {
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
         this.field3598 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3598[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3598[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3603 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3603[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1911730808"
   )
   void method4772() {
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-2102647201"
   )
   public Model method4775(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class50.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method2535(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3598 != null && var2 < this.field3598.length) {
            var6 = this.field3598[var2];
            var5 = class50.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method2535(!var4.method2914(var3) & !var5.method2914(var6));
            var7.method2543(var4, var3);
            var7.method2543(var5, var6);
            return var7;
         } else {
            var7 = var1.method2535(!var4.method2914(var3));
            var7.method2543(var4, var3);
            return var7;
         }
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
      field3596 = new NodeCache(64);
      field3599 = new NodeCache(100);
   }
}
