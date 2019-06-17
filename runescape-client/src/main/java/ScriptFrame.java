import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("ScriptFrame")
public class ScriptFrame {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lcg;"
   )
   @Export("script")
   Script script;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1715361849
   )
   @Export("pc")
   int pc;
   @ObfuscatedName("q")
   @Export("intLocals")
   int[] intLocals;
   @ObfuscatedName("w")
   @Export("stringLocals")
   String[] stringLocals;

   ScriptFrame() {
      this.pc = -1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([Lgc;II)Lgc;",
      garbageValue = "-1726705535"
   )
   @Export("findEnumerated")
   public static Enumerated findEnumerated(Enumerated[] var0, int var1) {
      Enumerated[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Enumerated var4 = var2[var3];
         if(var1 == var4.ordinal()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("kl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-423549686"
   )
   static void method1138() {
      if(ClientParameter.field3645 != null) {
         Client.__client_ss = Client.cycle;
         ClientParameter.field3645.method4719();

         for(int var0 = 0; var0 < Client.players.length; ++var0) {
            if(Client.players[var0] != null) {
               ClientParameter.field3645.method4738((Client.players[var0].x >> 7) + class50.baseX, (Client.players[var0].y >> 7) + GraphicsObject.baseY);
            }
         }
      }

   }
}
