import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class45 extends class28 {
   @ObfuscatedName("cb")
   @Export("middleMouseMovesCamera")
   static boolean middleMouseMovesCamera;
   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   @Export("region")
   static Region region;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -159111639
   )
   int field559;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1565752951
   )
   int field560;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 835978941
   )
   int field566;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 258486849
   )
   int field562;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgv;Lgv;I)V",
      garbageValue = "-534662674"
   )
   void method628(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field480.field485) {
         throw new IllegalStateException("");
      } else {
         super.field389 = var2.readUnsignedByte();
         super.field393 = var2.readUnsignedByte();
         super.field390 = var2.readUnsignedShort();
         super.field388 = var2.readUnsignedShort();
         this.field559 = var2.readUnsignedByte();
         this.field560 = var2.readUnsignedByte();
         super.field392 = var2.readUnsignedShort();
         super.field391 = var2.readUnsignedShort();
         this.field566 = var2.readUnsignedByte();
         this.field562 = var2.readUnsignedByte();
         super.field393 = Math.min(super.field393, 4);
         super.field394 = new short[1][64][64];
         super.field395 = new short[super.field393][64][64];
         super.field396 = new byte[super.field393][64][64];
         super.field397 = new byte[super.field393][64][64];
         super.field398 = new class31[super.field393][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field471.field470) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field392 && var5 == super.field391 && var6 == this.field566 && var7 == this.field562) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method211(var8 + this.field566 * 8, var9 + this.field562 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1538039077"
   )
   boolean method629(int var1, int var2) {
      return var1 < this.field566 * 8?false:(var2 < this.field562 * 8?false:(var1 >= this.field566 * 8 + 8?false:var2 < this.field562 * 8 + 8));
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-763999868"
   )
   int method644() {
      return this.field559;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-972185501"
   )
   int method631() {
      return this.field560;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "69"
   )
   int method630() {
      return this.field566;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1902357198"
   )
   int method640() {
      return this.field562;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class45)) {
         return false;
      } else {
         class45 var2 = (class45)var1;
         return super.field392 == var2.field392 && var2.field391 == super.field391?this.field566 == var2.field566 && var2.field562 == this.field562:false;
      }
   }

   public int hashCode() {
      return super.field392 | super.field391 << 8 | this.field566 << 16 | this.field562 << 24;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Ljs;",
      garbageValue = "-1833386817"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.sequences.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.seq_ref.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         Sequence.sequences.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)Ljh;",
      garbageValue = "116"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.npcs.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.NpcDefinition_indexCache.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         NPCComposition.npcs.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1966613911"
   )
   public static int method652(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var0 + var2) / var1 - var2;
   }

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-851615722"
   )
   static void method655(int var0) {
      if(var0 == -1 && !Client.field991) {
         class214.field2630.method3904();
         class214.field2631 = 1;
         class214.field2632 = null;
      } else if(var0 != -1 && var0 != Client.field1091 && Client.field1090 != 0 && !Client.field991) {
         IndexData var1 = Size.indexTrack1;
         int var2 = Client.field1090;
         class214.field2631 = 1;
         class214.field2632 = var1;
         Ignore.field810 = var0;
         class262.field3474 = 0;
         class35.field477 = var2;
         class214.field2627 = false;
         FontName.field3711 = 2;
      }

      Client.field1091 = var0;
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(Lcf;III)V",
      garbageValue = "371185552"
   )
   static final void method651(ContextMenuRow var0, int var1, int var2) {
      VertexNormal.menuAction(var0.param0, var0.param1, var0.type, var0.identifier, var0.option, var0.option, var1, var2);
   }
}
