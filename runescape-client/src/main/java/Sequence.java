import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ki")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   @Export("seq_ref")
   static IndexDataBase seq_ref;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   @Export("sequences")
   public static NodeCache sequences;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   @Export("skeletons")
   public static NodeCache skeletons;
   @ObfuscatedName("by")
   static String field3752;
   @ObfuscatedName("y")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("k")
   int[] field3756;
   @ObfuscatedName("s")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("p")
   public int[] field3765;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -779145849
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("m")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("h")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1565531035
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1508932993
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 861878369
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 513502093
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1289500521
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1324998121
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1085673467
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgy;B)V",
      garbageValue = "-21"
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgy;IB)V",
      garbageValue = "0"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
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
         this.field3756 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3756[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3756[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3765 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3765[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1318499227"
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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lel;IS)Lel;",
      garbageValue = "13206"
   )
   public Model method5285(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = TextureProvider.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2756(true);
      } else {
         Model var4 = var1.method2756(!var3.method3141(var2));
         var4.method2764(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lel;III)Lel;",
      garbageValue = "653292672"
   )
   Model method5286(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = TextureProvider.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var4 == null) {
         return var1.method2756(true);
      } else {
         Model var5 = var1.method2756(!var4.method3141(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2769();
         } else if(var3 == 2) {
            var5.method2768();
         } else if(var3 == 3) {
            var5.rotateY90Ccw();
         }

         var5.method2764(var4, var2);
         if(var3 == 1) {
            var5.rotateY90Ccw();
         } else if(var3 == 2) {
            var5.method2768();
         } else if(var3 == 3) {
            var5.method2769();
         }

         return var5;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lel;II)Lel;",
      garbageValue = "-1997495990"
   )
   Model method5305(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = TextureProvider.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2781(true);
      } else {
         Model var4 = var1.method2781(!var3.method3141(var2));
         var4.method2764(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lel;ILki;IB)Lel;",
      garbageValue = "11"
   )
   public Model method5288(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = TextureProvider.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var5 == null) {
         return var3.method5285(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = TextureProvider.getFrames(var4 >> 16);
         var4 &= 65535;
         Model var7;
         if(var6 == null) {
            var7 = var1.method2756(!var5.method3141(var2));
            var7.method2764(var5, var2);
            return var7;
         } else {
            var7 = var1.method2756(!var5.method3141(var2) & !var6.method3141(var4));
            var7.method2765(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lel;II)Lel;",
      garbageValue = "-502337322"
   )
   public Model method5289(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = TextureProvider.getFrames(var3 >> 16);
      var3 &= 65535;
      if(var4 == null) {
         return var1.method2756(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3756 != null && var2 < this.field3756.length) {
            var6 = this.field3756[var2];
            var5 = TextureProvider.getFrames(var6 >> 16);
            var6 &= 65535;
         }

         Model var7;
         if(var5 != null && var6 != 65535) {
            var7 = var1.method2756(!var4.method3141(var3) & !var5.method3141(var6));
            var7.method2764(var4, var3);
            var7.method2764(var5, var6);
            return var7;
         } else {
            var7 = var1.method2756(!var4.method3141(var3));
            var7.method2764(var4, var3);
            return var7;
         }
      }
   }
}
