import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("seq_ref")
   public static IndexDataBase seq_ref;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("skel_ref")
   public static IndexDataBase skel_ref;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("skin_ref")
   public static IndexDataBase skin_ref;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("sequences")
   public static NodeCache sequences;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("skeletons")
   public static NodeCache skeletons;
   @ObfuscatedName("w")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("t")
   int[] field3682;
   @ObfuscatedName("d")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("z")
   public int[] field3684;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1112020643
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("c")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("o")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -528182189
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1915948831
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 317712565
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1262719123
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -39411471
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1556838705
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1133717543
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "-1283100756"
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-1240726539"
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
         this.field3682 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3682[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3682[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3684 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3684[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2137203043"
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Les;II)Les;",
      garbageValue = "1218056497"
   )
   public Model method5079(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = ScriptVarType.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2737(true);
      } else {
         Model var4 = var1.method2737(!var3.method3117(var2));
         var4.method2723(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Les;IIS)Les;",
      garbageValue = "256"
   )
   Model method5080(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = ScriptVarType.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var4 == null) {
         return var1.method2737(true);
      } else {
         Model var5 = var1.method2737(!var4.method3117(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2728();
         } else if(var3 == 2) {
            var5.method2727();
         } else if(var3 == 3) {
            var5.rotateY90Ccw();
         }

         var5.method2723(var4, var2);
         if(var3 == 1) {
            var5.rotateY90Ccw();
         } else if(var3 == 2) {
            var5.method2727();
         } else if(var3 == 3) {
            var5.method2728();
         }

         return var5;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Les;IB)Les;",
      garbageValue = "60"
   )
   Model method5081(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = ScriptVarType.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2736(true);
      } else {
         Model var4 = var1.method2736(!var3.method3117(var2));
         var4.method2723(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Les;ILje;IB)Les;",
      garbageValue = "0"
   )
   public Model method5082(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = ScriptVarType.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var5 == null) {
         return var3.method5079(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = ScriptVarType.getFrames(var4 >> 16);
         var4 &= 65535;
         Model var7;
         if(var6 == null) {
            var7 = var1.method2737(!var5.method3117(var2));
            var7.method2723(var5, var2);
            return var7;
         } else {
            var7 = var1.method2737(!var5.method3117(var2) & !var6.method3117(var4));
            var7.method2731(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Les;II)Les;",
      garbageValue = "1265489691"
   )
   public Model method5083(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = ScriptVarType.getFrames(var3 >> 16);
      var3 &= 65535;
      if(var4 == null) {
         return var1.method2737(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3682 != null && var2 < this.field3682.length) {
            var6 = this.field3682[var2];
            var5 = ScriptVarType.getFrames(var6 >> 16);
            var6 &= 65535;
         }

         Model var7;
         if(var5 != null && var6 != 65535) {
            var7 = var1.method2737(!var4.method3117(var3) & !var5.method3117(var6));
            var7.method2723(var4, var3);
            var7.method2723(var5, var6);
            return var7;
         } else {
            var7 = var1.method2737(!var4.method3117(var3));
            var7.method2723(var4, var3);
            return var7;
         }
      }
   }
}
