import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jr")
public class class271 extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   static IndexDataBase field3476;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static NodeCache field3474;
   @ObfuscatedName("o")
   char field3478;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1124298085
   )
   public int field3477;
   @ObfuscatedName("a")
   public String field3475;
   @ObfuscatedName("h")
   boolean field3479;

   static {
      field3474 = new NodeCache(64);
   }

   class271() {
      this.field3479 = true;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-119"
   )
   void method4862() {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgn;B)V",
      garbageValue = "64"
   )
   void method4861(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4864(var1, var2);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgn;IB)V",
      garbageValue = "-11"
   )
   void method4864(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3478 = class137.method3041(var1.readByte());
      } else if(var2 == 2) {
         this.field3477 = var1.readInt();
      } else if(var2 == 4) {
         this.field3479 = false;
      } else if(var2 == 5) {
         this.field3475 = var1.readString();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1612334919"
   )
   public boolean method4877() {
      return this.field3478 == 's';
   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "476355983"
   )
   static final void method4881(int var0, int var1) {
      if(Client.hintArrowTargetType == 2) {
         class225.worldToScreen((Client.hintArrowX - ScriptState.baseX << 7) + Client.hintArrowOffsetX, (Client.hintArrowY - WorldMapType1.baseY << 7) + Client.hintArrowOffsetY, Client.hintArrowType * 2);
         if(Client.screenX > -1 && Client.gameCycle % 20 < 10) {
            FaceNormal.headIconsHint[0].drawAt(var0 + Client.screenX - 12, Client.screenY + var1 - 28);
         }

      }
   }
}
