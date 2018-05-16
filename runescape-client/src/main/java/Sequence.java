import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("seq_ref")
   public static IndexDataBase seq_ref;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("skel_ref")
   public static IndexDataBase skel_ref;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("skin_ref")
   public static IndexDataBase skin_ref;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("sequences")
   static NodeCache sequences;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("skeletons")
   static NodeCache skeletons;
   @ObfuscatedName("n")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("h")
   int[] field3554;
   @ObfuscatedName("x")
   @Export("frameLengths")
   public int[] frameLengths;
   @ObfuscatedName("j")
   public int[] field3556;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1432697333
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("l")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("d")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1179183481
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1245201533
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 78204383
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1489530045
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -158478119
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1261603831
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2009554759
   )
   @Export("replyMode")
   public int replyMode;

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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "1587618407"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-1281363822"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedShort();
         this.frameLengths = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameLengths[var4] = var1.readUnsignedShort();
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
         this.field3554 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3554[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3554[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3556 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3556[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "376562190"
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ldk;II)Ldk;",
      garbageValue = "363237978"
   )
   @Export("transformActorModel")
   public Model transformActorModel(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class309.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.toSharedModel(true);
      } else {
         Model var4 = var1.toSharedModel(!var3.method3085(var2));
         var4.method2783(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ldk;III)Ldk;",
      garbageValue = "28823444"
   )
   @Export("transformObjectModel")
   Model transformObjectModel(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class309.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var4 == null) {
         return var1.toSharedModel(true);
      } else {
         Model var5 = var1.toSharedModel(!var4.method3085(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.rotateY270Ccw();
         } else if(var3 == 2) {
            var5.rotateY180Ccw();
         } else if(var3 == 3) {
            var5.rotateY90Ccw();
         }

         var5.method2783(var4, var2);
         if(var3 == 1) {
            var5.rotateY90Ccw();
         } else if(var3 == 2) {
            var5.rotateY180Ccw();
         } else if(var3 == 3) {
            var5.rotateY270Ccw();
         }

         return var5;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ldk;II)Ldk;",
      garbageValue = "963524727"
   )
   @Export("transformSpotAnimModel")
   Model transformSpotAnimModel(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class309.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.toSharedSpotAnimModel(true);
      } else {
         Model var4 = var1.toSharedSpotAnimModel(!var3.method3085(var2));
         var4.method2783(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ldk;ILjh;II)Ldk;",
      garbageValue = "-1304609036"
   )
   @Export("applyTransformations")
   public Model applyTransformations(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class309.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var5 == null) {
         return var3.transformActorModel(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class309.getFrames(var4 >> 16);
         var4 &= 65535;
         Model var7;
         if(var6 == null) {
            var7 = var1.toSharedModel(!var5.method3085(var2));
            var7.method2783(var5, var2);
            return var7;
         } else {
            var7 = var1.toSharedModel(!var5.method3085(var2) & !var6.method3085(var4));
            var7.method2777(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ldk;II)Ldk;",
      garbageValue = "-1957089369"
   )
   public Model method5235(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class309.getFrames(var3 >> 16);
      var3 &= 65535;
      if(var4 == null) {
         return var1.toSharedModel(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3554 != null && var2 < this.field3554.length) {
            var6 = this.field3554[var2];
            var5 = class309.getFrames(var6 >> 16);
            var6 &= 65535;
         }

         Model var7;
         if(var5 != null && var6 != 65535) {
            var7 = var1.toSharedModel(!var4.method3085(var3) & !var5.method3085(var6));
            var7.method2783(var4, var3);
            var7.method2783(var5, var6);
            return var7;
         } else {
            var7 = var1.toSharedModel(!var4.method3085(var3));
            var7.method2783(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Liv;IB)Llh;",
      garbageValue = "100"
   )
   public static IndexedSprite method5215(IndexDataBase var0, int var1) {
      byte[] var3 = var0.takeRecordFlat(var1);
      boolean var2;
      if(var3 == null) {
         var2 = false;
      } else {
         class171.decodeSprite(var3);
         var2 = true;
      }

      return !var2?null:class224.method4461();
   }
}
