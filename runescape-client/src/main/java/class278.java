import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jm")
public class class278 extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static IndexDataBase field3547;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   public static NodeCache field3541;
   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "[Lly;"
   )
   @Export("crossSprites")
   static SpritePixels[] crossSprites;
   @ObfuscatedName("n")
   char field3544;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 74148493
   )
   public int field3542;
   @ObfuscatedName("e")
   public String field3543;
   @ObfuscatedName("y")
   boolean field3545;

   static {
      field3541 = new NodeCache(64);
   }

   class278() {
      this.field3545 = true;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1387102249"
   )
   void method5032() {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgy;B)V",
      garbageValue = "-48"
   )
   void method5035(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method5034(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgy;IB)V",
      garbageValue = "-65"
   )
   void method5034(Buffer var1, int var2) {
      if(var2 == 1) {
         byte var4 = var1.readByte();
         int var5 = var4 & 255;
         if(var5 == 0) {
            throw new IllegalArgumentException("");
         }

         if(var5 >= 128 && var5 < 160) {
            char var6 = class314.cp1252AsciiExtension[var5 - 128];
            if(var6 == 0) {
               var6 = '?';
            }

            var5 = var6;
         }

         char var3 = (char)var5;
         this.field3544 = var3;
      } else if(var2 == 2) {
         this.field3542 = var1.readInt();
      } else if(var2 == 4) {
         this.field3545 = false;
      } else if(var2 == 5) {
         this.field3543 = var1.readString();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-298417834"
   )
   public boolean method5043() {
      return this.field3544 == 's';
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1436755339"
   )
   public static void method5044() {
      class326.classInfos = new CombatInfoList();
   }
}
