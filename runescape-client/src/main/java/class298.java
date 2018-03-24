import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kj")
public class class298 extends NameableContainer {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Llu;"
   )
   final JagexLoginType field3830;

   @ObfuscatedSignature(
      signature = "(Llu;)V"
   )
   public class298(JagexLoginType var1) {
      super(400);
      this.field3830 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)Lkv;",
      garbageValue = "-21"
   )
   Nameable vmethod5446() {
      return new Ignore();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)[Lkv;",
      garbageValue = "-827789091"
   )
   Nameable[] vmethod5470(int var1) {
      return new Ignore[var1];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgb;II)V",
      garbageValue = "841011621"
   )
   public void method5288(Buffer var1, int var2) {
      while(true) {
         if(var1.offset < var2) {
            int var3 = var1.readUnsignedByte();
            boolean var4 = (var3 & 1) == 1;
            Name var5 = new Name(var1.readString(), this.field3830);
            Name var6 = new Name(var1.readString(), this.field3830);
            var1.readString();
            if(var5 != null && var5.method5418()) {
               Ignore var7 = (Ignore)this.method5302(var4?var6:var5);
               if(var7 != null) {
                  this.method5352(var7, var5, var6);
                  continue;
               }

               if(this.getCount() < 400) {
                  int var8 = this.getCount();
                  var7 = (Ignore)this.method5307(var5, var6);
                  var7.field3839 = var8;
               }
               continue;
            }

            throw new IllegalStateException();
         }

         return;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)[Lgu;",
      garbageValue = "-1936813191"
   )
   static LoginPacket[] method5285() {
      return new LoginPacket[]{LoginPacket.field2453, LoginPacket.field2449, LoginPacket.field2448, LoginPacket.field2447};
   }
}
