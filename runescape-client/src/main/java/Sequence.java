import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jg")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("v")
   @Export("skeletons")
   public static NodeCache skeletons;
   @ObfuscatedName("r")
   @Export("sequences")
   public static NodeCache sequences;
   @ObfuscatedName("j")
   @Export("skel_ref")
   static IndexDataBase skel_ref;
   @ObfuscatedName("a")
   @Export("seq_ref")
   static IndexDataBase seq_ref;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 964163047
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("e")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("m")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 865985193
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1652071589
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("s")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("u")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1791941913
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1748349517
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("l")
   int[] field3616;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1221517269
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1695295085
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -153357275
   )
   @Export("replyMode")
   public int replyMode;
   @ObfuscatedName("w")
   public int[] field3609;

   static {
      sequences = new NodeCache(64);
      skeletons = new NodeCache(100);
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-446509277"
   )
   void method4619(Buffer var1, int var2) {
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
         this.field3616 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3616[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3616[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3609 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3609[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LModel;IS)LModel;",
      garbageValue = "3699"
   )
   public Model method4617(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class91.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2495(true);
      } else {
         Model var4 = var1.method2495(!var3.method2867(var2));
         var4.method2519(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;IB)LModel;",
      garbageValue = "-101"
   )
   public Model method4620(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class91.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method4617(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class91.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(var6 == null) {
            var7 = var1.method2495(!var5.method2867(var2));
            var7.method2519(var5, var2);
            return var7;
         } else {
            var7 = var1.method2495(!var5.method2867(var2) & !var6.method2867(var4));
            var7.method2504(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LModel;IIB)LModel;",
      garbageValue = "116"
   )
   Model method4618(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class91.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method2495(true);
      } else {
         Model var5 = var1.method2495(!var4.method2867(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2521();
         } else if(var3 == 2) {
            var5.method2515();
         } else if(var3 == 3) {
            var5.method2506();
         }

         var5.method2519(var4, var2);
         if(var3 == 1) {
            var5.method2506();
         } else if(var3 == 2) {
            var5.method2515();
         } else if(var3 == 3) {
            var5.method2521();
         }

         return var5;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-2065128073"
   )
   Model method4635(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class91.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2496(true);
      } else {
         Model var4 = var1.method2496(!var3.method2867(var2));
         var4.method2519(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-2032808093"
   )
   public Model method4629(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class91.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method2495(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3616 != null && var2 < this.field3616.length) {
            var6 = this.field3616[var2];
            var5 = class91.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method2495(!var4.method2867(var3) & !var5.method2867(var6));
            var7.method2519(var4, var3);
            var7.method2519(var5, var6);
            return var7;
         } else {
            var7 = var1.method2495(!var4.method2867(var3));
            var7.method2519(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1040719051"
   )
   @Export("post")
   void post() {
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1451573387"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4619(var1, var2);
      }
   }
}
