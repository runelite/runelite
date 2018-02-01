import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class45 extends class28 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 45950735
   )
   public static int field545;
   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   @Export("vorbisIndex")
   static IndexData vorbisIndex;
   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "Lcl;"
   )
   @Export("topContextMenuRow")
   static ContextMenuRow topContextMenuRow;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 808354809
   )
   int field548;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1078435491
   )
   int field542;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -242669759
   )
   int field546;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1846622843
   )
   int field543;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgj;Lgj;I)V",
      garbageValue = "1011117971"
   )
   void method630(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field468.field467) {
         throw new IllegalStateException("");
      } else {
         super.field379 = var2.readUnsignedByte();
         super.field381 = var2.readUnsignedByte();
         super.field384 = var2.readUnsignedShort();
         super.field376 = var2.readUnsignedShort();
         this.field548 = var2.readUnsignedByte();
         this.field542 = var2.readUnsignedByte();
         super.field377 = var2.readUnsignedShort();
         super.field378 = var2.readUnsignedShort();
         this.field546 = var2.readUnsignedByte();
         this.field543 = var2.readUnsignedByte();
         super.field381 = Math.min(super.field381, 4);
         super.field380 = new short[1][64][64];
         super.field382 = new short[super.field381][64][64];
         super.field386 = new byte[super.field381][64][64];
         super.field383 = new byte[super.field381][64][64];
         super.field385 = new class31[super.field381][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field461.field462) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field377 && var5 == super.field378 && var6 == this.field546 && var7 == this.field543) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method250(var8 + this.field546 * 8, var9 + this.field543 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1797597362"
   )
   boolean method631(int var1, int var2) {
      return var1 < this.field546 * 8?false:(var2 < this.field543 * 8?false:(var1 >= this.field546 * 8 + 8?false:var2 < this.field543 * 8 + 8));
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "35"
   )
   int method629() {
      return this.field548;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "12"
   )
   int method633() {
      return this.field542;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1851002948"
   )
   int method647() {
      return this.field546;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1256954945"
   )
   int method654() {
      return this.field543;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class45)) {
         return false;
      } else {
         class45 var2 = (class45)var1;
         return super.field377 == var2.field377 && var2.field378 == super.field378?this.field546 == var2.field546 && var2.field543 == this.field543:false;
      }
   }

   public int hashCode() {
      return super.field377 | super.field378 << 8 | this.field546 << 16 | this.field543 << 24;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1401344703"
   )
   public static void method653(int var0) {
      MouseInput.mouseIdleTicks = var0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "848613239"
   )
   public static void method637() {
      PlayerComposition.field2708.reset();
   }

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1789877157"
   )
   static final void method640() {
      int var0 = class92.playerIndexesCount;
      int[] var1 = class92.playerIndices;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.cachedPlayers[var1[var2]];
         if(var3 != null) {
            class25.method190(var3, 1);
         }
      }

   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2104309845"
   )
   static final void method655() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[var1 + 1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
               Client.menuTargets[var1 + 1] = var2;
               String var3 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
               Client.menuOptions[var1 + 1] = var3;
               int var4 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
               Client.menuTypes[var1 + 1] = var4;
               var4 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
               Client.menuActionParams0[var1 + 1] = var4;
               var4 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               Client.menuActionParams1[var1 + 1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
               Client.menuIdentifiers[var1 + 1] = var4;
               boolean var5 = Client.menuBooleanArray[var1];
               Client.menuBooleanArray[var1] = Client.menuBooleanArray[var1 + 1];
               Client.menuBooleanArray[var1 + 1] = var5;
               var0 = false;
            }
         }
      }

   }
}
