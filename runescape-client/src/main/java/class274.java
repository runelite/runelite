import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jq")
public class class274 extends class275 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   final JagexLoginType field3679;

   @ObfuscatedSignature(
      signature = "(Lld;)V"
   )
   public class274(JagexLoginType var1) {
      super(400);
      this.field3679 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lju;",
      garbageValue = "-98"
   )
   class273 vmethod5160() {
      return new class276();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)[Lju;",
      garbageValue = "-1319508722"
   )
   class273[] vmethod5161(int var1) {
      return new class276[var1];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgj;IS)V",
      garbageValue = "-10412"
   )
   public void method5029(Buffer var1, int var2) {
      while(true) {
         if(var1.offset < var2) {
            int var3 = var1.readUnsignedByte();
            boolean var4 = (var3 & 1) == 1;
            class280 var5 = new class280(var1.readString(), this.field3679);
            class280 var6 = new class280(var1.readString(), this.field3679);
            var1.readString();
            if(var5 != null && var5.method5132()) {
               class276 var7 = (class276)this.method5040(var4?var6:var5);
               if(var7 != null) {
                  this.method5042(var7, var5, var6);
                  continue;
               }

               if(this.method5036() < 400) {
                  var7 = (class276)this.method5045(var5, var6);
               }
               continue;
            }

            throw new IllegalStateException();
         }

         return;
      }
   }
}
